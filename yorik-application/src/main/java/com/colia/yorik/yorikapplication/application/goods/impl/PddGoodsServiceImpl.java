package com.colia.yorik.yorikapplication.application.goods.impl;

import com.colia.yorik.yorikapplication.application.goods.PddGoodsService;
import com.colia.yorik.yorikapplication.application.goods.adapter.GoodsVOMapper;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpPddClient;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsBasicInfoGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
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
    private GoodsVOMapper goodsVOMapper;


    /**
     * pdd推荐商品
     *
     * @param request pdd需要的请求参数
     * @return 商品流list
     */
    @Override
    public PddGoodsListVO getRecommendGoods(PddDdkGoodsRecommendGetRequest request) {
        PopClient client = HttpPddClient.getPddClient();
        PddDdkGoodsRecommendGetResponse response;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            log.error("PDD推荐商品接口异常", e);
            throw new BizProcessException("PDD推荐商品接口异常", e);
        }
        return goodsVOMapper.toPddGoodsVO(response.getGoodsBasicDetailResponse());
    }

    @Override
    public void getGoodsBasicInfo() {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsBasicInfoGetRequest request = new PddDdkGoodsBasicInfoGetRequest();
        List<Long> goodsIdList = new ArrayList<>();

        goodsIdList.add(0L);
        request.setGoodsIdList(goodsIdList);
        PddDdkGoodsBasicInfoGetResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            throw new BizProcessException("PDD获取商品详情接口异常", e);
        }
    }

    void getGoodsDetailInfo(List<Long> goodsIdList) {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        request.setCustomParameters("str");
        request.setGoodsIdList(goodsIdList);
        request.setPid("str");
        request.setPlanType(0);
        request.setSearchId("str");
        request.setZsDuoId(0L);
        PddDdkGoodsDetailResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
