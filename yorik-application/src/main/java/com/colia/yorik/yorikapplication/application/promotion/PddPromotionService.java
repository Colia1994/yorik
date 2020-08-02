package com.colia.yorik.yorikapplication.application.promotion;

import com.colia.yorik.yorikapplication.application.promotion.valueObject.PddPromotionVO;
import com.colia.yorik.yorikapplication.application.promotion.valueObject.PddUrlVO;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;

/**
 * 推广位相关
 *
 * @Author konglingyao
 * @Date 2020/7/24
 */
public interface PddPromotionService {


    /**
     * 创建一个推广位
     * 11054122_148291700
     *
     * @param pIdName 推广位名称 可选
     * @return 推广位信息
     */
    PddPromotionVO createOnePromotion(String pIdName);

    /**
     * 生成推广链接 商品直接转
     *
     * @param request 商品和所需链接信息
     * @return 生成的链接信息
     */
    PddUrlVO generatePromotionUrl(PddDdkGoodsPromotionUrlGenerateRequest request);

}
