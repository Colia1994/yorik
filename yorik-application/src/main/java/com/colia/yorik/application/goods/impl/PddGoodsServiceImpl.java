package com.colia.yorik.application.goods.impl;

import com.colia.yorik.application.goods.PddGoodsService;
import com.colia.yorik.application.goods.adapter.CatsMapper;
import com.colia.yorik.application.goods.adapter.GoodsMapper;
import com.colia.yorik.application.goods.request.GoodsDetailRequest;
import com.colia.yorik.application.goods.request.GoodsRecommendRequest;
import com.colia.yorik.application.goods.request.GoodsSearchRequest;
import com.colia.yorik.application.goods.valueObject.*;
import com.colia.yorik.common.infrastructure.exception.BizProcessException;
import com.colia.yorik.common.interfaces.annotation.RedisAuto;
import com.colia.yorik.support.utils.HttpClientUtils;
import com.colia.yorik.support.utils.JSONUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.*;
import com.pdd.pop.sdk.http.api.pop.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Slf4j
@Service
public class PddGoodsServiceImpl implements PddGoodsService {


    @Resource
    private GoodsMapper goodsVOMapper;

    @Resource
    private CatsMapper catsMapper;


    /**
     * pdd推荐商品
     *
     * @param request pdd需要的请求参数
     * @return 商品流list
     */
    @RedisAuto(prefixKey = "pdd:getRecommend", minute = 60)
    @Override
    public PddGoodsRecommendVO getPddRecommendGoods(GoodsRecommendRequest request) {
        PopClient client = HttpClientUtils.getPddClient();

        PddDdkGoodsRecommendGetRequest pddRequest = new PddDdkGoodsRecommendGetRequest();
        pddRequest.setChannelType(request.getChannelType());
        pddRequest.setLimit(request.getPageSize());
        //offset 需要计算
        pddRequest.setOffset((request.getPageNo() - 1) * request.getPageSize());
        pddRequest.setCatId(request.getCatId());

        PddDdkGoodsRecommendGetResponse response;
        try {
            log.info("getPddRecommendGoods:请求参数:{}", JSONUtil.transferToString(pddRequest));
            response = client.syncInvoke(pddRequest);
            log.info("getPddRecommendGoods:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("getPddRecommendGoods:接口异常", e);
            throw new BizProcessException("getPddRecommendGoods:接口异常", e);
        }

        if (response == null || response.getGoodsBasicDetailResponse() == null) {
            log.error("getPddRecommendGoods:接口返回数据为空");
            throw new BizProcessException("getPddRecommendGoods:接口返回数据为空");
        }

        return goodsVOMapper.toPddGoodsRecommendVO(response.getGoodsBasicDetailResponse());
    }

    /**
     * pdd根据商品id获取基本信息
     *
     * @param goodsIdList 商品id列表
     * @return 商品基本信息
     */
    @RedisAuto(prefixKey = "pdd:getGoodsBasic", minute = 30)
    @Override
    public List<PddGoodsBasicVO> getGoodsBasicInfoByID(List<Long> goodsIdList) {
        PopClient client = HttpClientUtils.getPddClient();

        PddDdkGoodsBasicInfoGetRequest request = new PddDdkGoodsBasicInfoGetRequest();

        request.setGoodsIdList(goodsIdList);
        PddDdkGoodsBasicInfoGetResponse response;
        try {
            log.info("getGoodsBasicInfoByID:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("getGoodsBasicInfoByID:返回参数:{}", JSONUtil.transferToString(response));

        } catch (Exception e) {
            log.error("PDD获取商品基本信息接口异常", e);
            throw new BizProcessException("PDD获取商品基本信息接口异常", e);
        }

        if (response == null || response.getGoodsBasicDetailResponse() == null) {
            log.error("getGoodsBasicInfoByID:接口返回数据为空");
            throw new BizProcessException("getGoodsBasicInfoByID:接口返回数据为空");
        }

        return goodsVOMapper.toPddGoodsBasicList(response.getGoodsBasicDetailResponse().getGoodsList());
    }

    /**
     * 获取pdd商品详情
     *
     * @param request 商品详情请求参数 goods_id
     * @return 商品详情
     */
    @RedisAuto(prefixKey = "pdd:getGoodsDetail", minute = 30)
    @Override
    public List<PddGoodsDetailVO> getPddGoodsDetailInfo(GoodsDetailRequest request) {
        PddDdkGoodsDetailRequest pddRequest = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(request.getGoodsId());
        pddRequest.setGoodsIdList(goodsIdList);
        pddRequest.setSearchId(request.getSearchId());
        pddRequest.setPid(request.getPid());
        pddRequest.setPlanType(request.getPlanType());

        PopClient client = HttpClientUtils.getPddClient();
        PddDdkGoodsDetailResponse response;
        try {
            log.info("getPddGoodsDetailInfo:请求参数:{}", JSONUtil.transferToString(pddRequest));
            response = client.syncInvoke(pddRequest);
            log.info("getPddGoodsDetailInfo:返回参数:{}", JSONUtil.transferToString(response));

        } catch (Exception e) {
            log.error("getPddGoodsDetailInfo:获取商品详细信息接口异常", e);
            throw new BizProcessException("getPddGoodsDetailInfo:获取商品详细信息接口异常", e);
        }

        if (response == null || response.getGoodsDetailResponse() == null) {
            log.error("getPddGoodsDetailInfo:接口返回数据为空");
            throw new BizProcessException("getPddGoodsDetailInfo:接口返回数据为空");
        }

        return goodsVOMapper.toPddGoodsDetailList(response.getGoodsDetailResponse().getGoodsDetails());
    }

    /**
     * 搜索商品
     *
     * @param request 请求相关
     * @return 商品列表
     */
    @RedisAuto(prefixKey = "pdd:searchGoods", minute = 10)
    @Override
    public PddGoodsSearchVO searchPddGoods(GoodsSearchRequest request) {
        PopClient client = HttpClientUtils.getPddClient();
        PddDdkGoodsSearchRequest pddRequest = new PddDdkGoodsSearchRequest();
        pddRequest.setActivityTags(request.getActivityTags());
        pddRequest.setKeyword(request.getKeyword());
        pddRequest.setWithCoupon(request.getWithCoupon());
        pddRequest.setPage(request.getPageNo());
        pddRequest.setPageSize(request.getPageSize());
        pddRequest.setListId(request.getListId());
        pddRequest.setSortType(request.getSortType());
        pddRequest.setCatId(request.getCatId());

        PddDdkGoodsSearchResponse response;
        try {
            log.info("searchPddGoods:请求参数:{}", JSONUtil.transferToString(pddRequest));
            response = client.syncInvoke(pddRequest);
            log.info("searchPddGoods:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("searchPddGoods:接口异常", e);
            throw new BizProcessException("searchPddGoods:接口异常", e);
        }

        if (response == null) {
            log.error("searchPddGoods:接口返回数据为空");

            throw new BizProcessException("searchPddGoods:接口返回数据为空");
        }

        return goodsVOMapper.toPddGoodsSearchVO(response.getGoodsSearchResponse());

    }

    /**
     * pdd查询商品类目
     *
     * @return 类目信息
     */
    @RedisAuto(prefixKey = "pdd:searchCats", minute = 60)
    @Override
    public PddCatsVO searchPddCats() {
        PopClient client = HttpClientUtils.getPddClient();

        PddGoodsCatsGetRequest request = new PddGoodsCatsGetRequest();
        request.setParentCatId(0L);
        PddGoodsCatsGetResponse response;
        try {
            log.info("searchPddCats:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
//            searchPddOpts();
//            log.info("searchPddCats:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("searchPddCats:接口异常", e);
            throw new BizProcessException("searchPddCats:接口异常", e);
        }

        if (response == null || response.getGoodsCatsGetResponse() == null) {
            log.error("searchPddCats:接口返回数据为空");
            throw new BizProcessException("searchPddCats:接口返回数据为空");
        }
        return catsMapper.toPddCats(response.getGoodsCatsGetResponse());
    }

    public void searchPddOpts() {
        PopClient client = HttpClientUtils.getPddClient();

        PddGoodsOptGetRequest request = new PddGoodsOptGetRequest();
        request.setParentOptId(9016);
        PddGoodsOptGetResponse response;
        try {
            log.info("searchPddCats:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("searchPddCats:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("searchPddCats:接口异常", e);
            throw new BizProcessException("searchPddCats:接口异常", e);
        }

        if (response == null || response.getGoodsOptGetResponse() == null) {
            log.error("searchPddCats:接口返回数据为空");
            throw new BizProcessException("searchPddCats:接口返回数据为空");
        }
//        return catsMapper.toPddCats(response.getGoodsCatsGetResponse());
    }


}
