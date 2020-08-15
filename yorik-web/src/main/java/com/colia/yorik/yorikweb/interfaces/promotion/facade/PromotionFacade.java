package com.colia.yorik.yorikweb.interfaces.promotion.facade;

import com.colia.yorik.yorikapplication.application.promotion.request.ConvertUrlRequest;
import com.colia.yorik.yorikapplication.application.promotion.request.PromotionUrlRequest;
import com.colia.yorik.yorikweb.interfaces.promotion.facade.dto.UrlDTO;

/**
 * @Author konglingyao
 * @Date 2020/7/30
 */
public interface PromotionFacade {


    /**
     * 生成推广链接 通过商品id
     *
     * @param params 商品id和链接可选项
     * @return 链接信息
     */
    UrlDTO generatePromotionUrl(PromotionUrlRequest params);

    /**
     * 转换推广链接 通过商品id
     *
     * @param params 原始链接
     * @return 链接信息
     */
    UrlDTO convertPromotionUrl(ConvertUrlRequest params);
}
