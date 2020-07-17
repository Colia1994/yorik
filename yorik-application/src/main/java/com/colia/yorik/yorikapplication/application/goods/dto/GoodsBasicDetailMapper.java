package com.colia.yorik.yorikapplication.application.goods.dto;

import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Mapper(componentModel = "spring")
public interface GoodsBasicDetailMapper {

    GoodsBasicDetailListItemDTO toDto(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem item);

    GoodsBasicDetailDTO toDto(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse response);

}
