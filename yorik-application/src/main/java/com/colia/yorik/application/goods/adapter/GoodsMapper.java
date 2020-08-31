package com.colia.yorik.application.goods.adapter;

import com.colia.yorik.application.goods.valueObject.*;
import com.colia.yorik.common.infrastructure.adapter.StringStrategy;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
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


    PddGoodsRecommendVO toPddGoodsRecommendVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse response);

    List<PddGoodsBasicVO> toPddGoodsBasicList(List<PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem> list);

    List<PddGoodsDetailVO> toPddGoodsDetailList(List<PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> list);

    PddGoodsSearchVO toPddGoodsSearchVO(PddDdkGoodsSearchResponse.GoodsSearchResponse response);

    TBGoodsRecommendVO toTBGoodsRecommendVO(TbkDgOptimusMaterialResponse list);

}
