package com.colia.yorik.yorikapplication.application.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.*;
import com.colia.yorik.yorikcommon.infrastructure.adapter.StringStrategy;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import com.taobao.api.response.JuItemsSearchResponse;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * mapstruct 商品通用转换器
 *
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Mapper(componentModel = "spring", uses = StringStrategy.class)
public interface GoodsMapper {

    /**
     * pdd商品推荐商品列表转换
     * 依赖 toPddGoodDetailVO 接口
     *
     * @param response 推荐商品列表
     * @return 业务实体
     */
    PddGoodsRecommendVO toPddGoodsRecommendVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse response);

    /**
     * 转换pdd 商品基本信息
     *
     * @return pdd商品基本信息
     */
    List<PddGoodsBasicVO> toPddGoodsBasicList(List<PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem> list);

    /**
     * 转换pdd 商品详情信息
     *
     * @return pdd商品详情信息
     */
    List<PddGoodsDetailVO> toPddGoodsDetailList(List<PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> list);

    PddGoodsSearchVO toPddGoodsSearchVO(PddDdkGoodsSearchResponse.GoodsSearchResponse response);


    TBGoodsRecommendVO toTBGoodsSearchVO(JuItemsSearchResponse.PaginationResult list);

}
