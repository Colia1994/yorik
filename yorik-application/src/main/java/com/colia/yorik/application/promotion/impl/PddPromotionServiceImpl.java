package com.colia.yorik.application.promotion.impl;

import com.colia.yorik.application.promotion.valueObject.PddUrlVO;
import com.colia.yorik.application.promotion.PddPromotionService;
import com.colia.yorik.application.promotion.adapter.PromotionMapper;
import com.colia.yorik.application.promotion.request.PromotionUrlRequest;
import com.colia.yorik.application.promotion.valueObject.PddPromotionVO;
import com.colia.yorik.common.infrastructure.constant.PddConstant;
import com.colia.yorik.common.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.utils.HttpClientUtils;
import com.colia.yorik.support.utils.JSONUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsZsUnitUrlGenRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsZsUnitUrlGenResponse;
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
    public PddPromotionVO createOnePromotion(String pIdName) {
        PopClient client = HttpClientUtils.getPddClient();

        PddDdkGoodsPidGenerateRequest request = new PddDdkGoodsPidGenerateRequest();
        request.setNumber(1L);

        List<String> pIdNameList = new ArrayList<>();
        pIdNameList.add(pIdName);
        request.setPIdNameList(pIdNameList);
        PddDdkGoodsPidGenerateResponse response;
        try {
            log.info("createOnePromotion:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("createOnePromotion:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("PDD创建一个推广位接口异常", e);
            throw new BizProcessException("PDD创建一个推广位接口异常", e);
        }
        if (response == null || response.getPIdGenerateResponse() == null
                || response.getPIdGenerateResponse().getPIdList() == null) {
            log.error("createOnePromotion:接口返回数据为空");
            throw new BizProcessException("createOnePromotion:接口返回数据异常，数据为空");
        }
        return promotionMapper.toPopVO(response.getPIdGenerateResponse().getPIdList().get(0));
    }

    /**
     * 生成推广链接 商品直接转
     *
     * @param params 商品和所需链接信息
     * @return 生成的链接信息
     */
    @Override
    public PddUrlVO generatePromotionUrl(PromotionUrlRequest params) {
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        List<Long> goodIdList = new ArrayList<>();
        goodIdList.add(params.getGoodsId());
        request.setGoodsIdList(goodIdList);
        request.setCustomParameters(params.getCustomParameters());
        //qq
        request.setGenerateQqApp(params.getGenerateQqApp());
        //coupon
        request.setGenerateMallCollectCoupon(params.getGenerateMallCollectCoupon());
        //weChat
        request.setGenerateWeApp(params.getGenerateWeApp());
        request.setGenerateWeappWebview(params.getGenerateWeappWebview());

        request.setGenerateSchemaUrl(params.getGenerateSchemaUrl());
        request.setGenerateShortUrl(params.getGenerateShortUrl());
        request.setMultiGroup(params.getMultiGroup());
        request.setSearchId(params.getSearchId());
        PopClient client = HttpClientUtils.getPddClient();
        request.setPId(PddConstant.DEFAULT_PID);
        PddDdkGoodsPromotionUrlGenerateResponse response;
        try {
            log.info("generatePromotionUrl:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("generatePromotionUrl:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("generatePromotionUrl接口异常", e);
            throw new BizProcessException("generatePromotionUrl接口异常", e);
        }
        if (response == null || response.getGoodsPromotionUrlGenerateResponse() == null
                || response.getGoodsPromotionUrlGenerateResponse().getGoodsPromotionUrlList() == null) {
            log.error("generatePromotionUrl接口返回数据异常,数据为空");
            throw new BizProcessException("generatePromotionUrl接口返回数据异常，数据为空");
        }

        return promotionMapper.toUrlVO(response.getGoodsPromotionUrlGenerateResponse().getGoodsPromotionUrlList().get(0));
    }

    /**
     * 将其他推广者的链接转为固定推广位的链接
     *
     * @param sourceUrl 原链接
     * @return 新的url链接
     */
    @Override
    public PddUrlVO convertPromotionUrl(String sourceUrl) {
        PopClient client = HttpClientUtils.getPddClient();

        PddDdkGoodsZsUnitUrlGenRequest request = new PddDdkGoodsZsUnitUrlGenRequest();
        request.setPid(PddConstant.DEFAULT_PID);
        request.setSourceUrl(sourceUrl);
//        request.setCustomParameters("str");
        PddDdkGoodsZsUnitUrlGenResponse response;
        try {
            log.info("convertPromotionUrl:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("convertPromotionUrl:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("convertPromotionUrl:接口异常", e);
            throw new BizProcessException("convertPromotionUrl:接口异常", e);
        }
        if (response == null || response.getGoodsZsUnitGenerateResponse() == null) {
            log.error("convertPromotionUrl:接口返回数据异常,数据为空");
            throw new BizProcessException("convertPromotionUrl:接口返回数据异常，数据为空");
        }
        return promotionMapper.toUrlVO(response.getGoodsZsUnitGenerateResponse());
    }

}


