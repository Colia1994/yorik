package com.colia.yorik.yorikapplication.application.goods.dto;

import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * mapstruct 商品通用转换器
 * @Author konglingyao
 * @Date 2020/7/17
 */
@Mapper(componentModel = "spring")
public interface GoodsMapper {

    /**
     * 转换成通用商品dto
     * @param item 推荐商品vo
     * @return 通用商品dto
     */
    GoodsBasicDetailListItemDTO pddVoToDto(PddGoodsDetailVO item);

    /**
     * 转换成通用商品dto
     * @param listVO 推荐商品list
     * @return 通用商品分页dto
     */
    @Mappings({
            @Mapping(source = "list", target = "records"),
    })
    GoodsBasicDetailDTO pddVoToDto(PddGoodsListVO listVO);

    /**
     * pdd商品推荐商品详情转换
     * @param item 推荐商品详情信息
     * @return 业务实体
     */
    PddGoodsDetailVO toPddGoodDetailVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem item);

    /**
     * pdd商品推荐商品列表转换
     * 依赖 toPddGoodDetailVO 接口
     * @param response 推荐商品列表
     * @return 业务实体
     */
    PddGoodsListVO toPddGoodsVO(PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse response);

}
