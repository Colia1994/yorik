package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.*;
import com.colia.yorik.yorikcommon.infrastructure.adapter.StringStrategy;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Mapper(componentModel = "spring",uses = StringStrategy.class)
public interface GoodsDTOMapper {


    @Mappings({
            @Mapping(source = "goodsList", target = "records"),
            @Mapping(source = "totalCount", target = "total"),
    })
    GoodsListDTO pddVOToDTO(PddGoodsSearchVO item);


    @Mappings({
            @Mapping(source = "list", target = "records"),
    })
    GoodsListDTO pddVOToDTO(PddGoodsRecommendVO listVO);


    GoodsDetailDTO pddVOToDTO(PddGoodsDetailVO item);

    @Mappings({
            @Mapping(source = "itemId", target = "goodsId"),
            @Mapping(source = "picUrlForPC", target = "goodsImageUrl"),
            @Mapping(source = "picUrlForWL", target = "goodsThumbnailUrl"),
            @Mapping(source = "title", target = "goodsName"),
            @Mapping(source = "actPrice", target = "minGroupPrice"),
            @Mapping(source = "actPrice", target = "minNormalPrice"),
    })
    GoodsDetailDTO tbVOToDTO(TBGoodsDetailVO item);

    @Mappings({
            @Mapping(source = "modelList", target = "records"),
            @Mapping(source = "currentPage", target = "current"),
            @Mapping(source = "totalItem", target = "total")
    })
    GoodsListDTO tbVOToDTO(TBGoodsRecommendVO listVO);
}
