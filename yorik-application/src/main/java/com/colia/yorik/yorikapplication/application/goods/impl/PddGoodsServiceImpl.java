package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikapplication.application.goods.adapter.CatsMapper;
import com.colia.yorik.yorikapplication.application.goods.adapter.GoodsMapper;
import com.colia.yorik.yorikapplication.application.goods.valueObject.*;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpClientUtils;
import com.colia.yorik.yoriksupport.utils.JSONUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.*;
import com.pdd.pop.sdk.http.api.pop.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Override
    public PddGoodsRecommendVO getPddRecommendGoods(PddDdkGoodsRecommendGetRequest request) {
        PopClient client = HttpClientUtils.getPddClient();
        PddDdkGoodsRecommendGetResponse response;
        try {
            log.info("getPddRecommendGoods:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
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
    @Override
    public List<PddGoodsDetailVO> getPddGoodsDetailInfo(PddDdkGoodsDetailRequest request) {

        PopClient client = HttpClientUtils.getPddClient();
        PddDdkGoodsDetailResponse response;
        try {
            log.info("getPddGoodsDetailInfo:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
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
    @Override
    public PddGoodsSearchVO searchPddGoods(PddDdkGoodsSearchRequest request) {
        PopClient client = HttpClientUtils.getPddClient();


        PddDdkGoodsSearchResponse response;
        try {
            log.info("searchPddGoods:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
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
