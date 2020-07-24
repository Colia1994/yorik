package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.mapstruct.Mapper;

/**
 * mapstruct 商品通用转换器
 *
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Mapper(componentModel = "spring")
public interface GoodsVOMapper {


    /**
     * pdd商品推荐商品详情转换
     *
     * @param item 推荐商品详情信息
     * @return 业务实体
     */
    PddGoodsDetailVO toPddGoodDetailVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem item);

    /**
     * pdd商品推荐商品列表转换
     * 依赖 toPddGoodDetailVO 接口
     *
     * @param response 推荐商品列表
     * @return 业务实体
     */
    PddGoodsListVO toPddGoodsVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse response);

}
