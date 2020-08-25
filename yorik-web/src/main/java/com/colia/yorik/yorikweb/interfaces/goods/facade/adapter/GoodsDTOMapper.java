package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.application.goods.valueObject.*;
import com.colia.yorik.common.infrastructure.adapter.StringStrategy;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Mapper(componentModel = "spring", uses = StringStrategy.class)
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


    GoodsDetailDTO tbVOToDTO(TBGoodsDetailVO item);


    GoodsListDTO tbVOToDTO(TBGoodsRecommendVO listVO);
}
