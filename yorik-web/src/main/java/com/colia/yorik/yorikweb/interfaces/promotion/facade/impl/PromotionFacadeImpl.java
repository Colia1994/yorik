package com.colia.yorik.yorikweb.interfaces.promotion.facade.impl;

import com.colia.yorik.yorikapplication.application.promotion.PddPromotionService;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.PromotionFacade;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.adapter.UrlDTOAssembler;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.dto.UrlDTO;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.request.ConvertUrlRequest;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.request.PromotionUrlRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/31
 */
@Slf4j
@Service
public class PromotionFacadeImpl implements PromotionFacade {

    @Resource
    private UrlDTOAssembler urlDTOAssembler;

    @Resource
    private PddPromotionService pddPromotionService;

    /**
     * 生成推广链接 通过商品id
     *
     * @param params 商品id和链接可选项
     * @return 链接信息
     */
    @Override
    public UrlDTO generatePromotionUrl(PromotionUrlRequest params) {
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

        return urlDTOAssembler.toDTO(pddPromotionService.generatePromotionUrl(request));
    }

    /**
     * 转换推广链接 通过商品id
     *
     * @param params 原始链接
     * @return 链接信息
     */
    @Override
    public UrlDTO convertPromotionUrl(ConvertUrlRequest params) {
        return null;
    }
}
