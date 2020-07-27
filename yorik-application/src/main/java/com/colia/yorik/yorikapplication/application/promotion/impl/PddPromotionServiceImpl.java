package com.colia.yorik.yorikapplication.application.promotion.impl;

import com.colia.yorik.yorikapplication.application.promotion.PddPromotionService;
import com.colia.yorik.yorikapplication.application.promotion.adapter.PromotionMapper;
import com.colia.yorik.yorikapplication.application.promotion.valueObject.PromotionVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpPddClient;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Slf4j
@Service
public class PddPromotionServiceImpl implements PddPromotionService {

    @Resource
    private PromotionMapper promotionMapper;


    /**
     * 创建一个推广位
     *
     * @param pIdName 推广位名称 可选
     * @return 推广位信息
     */
    @Override
    public PromotionVO createOnePromotion(String pIdName) {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsPidGenerateRequest request = new PddDdkGoodsPidGenerateRequest();
        request.setNumber(1L);

        List<String> pIdNameList = new ArrayList<>();
        pIdNameList.add(pIdName);
        request.setPIdNameList(pIdNameList);
        PddDdkGoodsPidGenerateResponse response;
        try {
            log.info("createOnePromotion:请求参数:{}", JsonUtil.transferToJson(request));
            response = client.syncInvoke(request);
            log.info("createOnePromotion:返回参数:{}", JsonUtil.transferToJson(response));
        } catch (Exception e) {
            log.error("PDD创建一个推广位接口异常", e);
            throw new BizProcessException("PDD创建一个推广位接口异常", e);
        }
        return promotionMapper.toPopVO(response.getPIdGenerateResponse().getPIdList().get(0));
    }

    @Override
    public void generatePromotionUrl(PddDdkGoodsPromotionUrlGenerateRequest request1) {
        PopClient client = HttpPddClient.getPddClient();

        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
//        request.setCustomParameters("str");
        request.setGenerateMallCollectCoupon(true);
        request.setGenerateQqApp(false);
        request.setGenerateSchemaUrl(true);
        request.setGenerateShortUrl(true);
        request.setGenerateWeappWebview(true);
        request.setGenerateWeiboappWebview(true);
        request.setGenerateWeApp(true);
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(149047697230L);
        request.setGoodsIdList(goodsIdList);
        request.setMultiGroup(false);
        request.setPId("11054122_148291700");
        request.setSearchId("4dd9b52a199ab4e13a473189ee86cbf7d85");
//        request.setZsDuoId(0L);
        PddDdkGoodsPromotionUrlGenerateResponse response = null;
        try {
            log.info("generatePromotionUrl:请求参数:{}", JsonUtil.transferToJson(request));
            response = client.syncInvoke(request);
            log.info("generatePromotionUrl:返回参数:{}", JsonUtil.transferToJson(response));

        } catch (Exception e) {
            log.error("generatePromotionUrl接口异常", e);
            throw new BizProcessException("generatePromotionUrl接口异常", e);
        }

    }

}
