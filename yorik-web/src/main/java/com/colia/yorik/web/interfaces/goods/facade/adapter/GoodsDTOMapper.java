package com.colia.yorik.web.interfaces.goods.facade.adapter;

import com.colia.yorik.application.goods.valueObject.*;
import com.colia.yorik.common.infrastructure.adapter.MoneyStrategy;
import com.colia.yorik.common.infrastructure.adapter.StringStrategy;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.web.interfaces.goods.facade.dto.GoodsListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Mapper(componentModel = "spring", uses = {StringStrategy.class, MoneyStrategy.class})
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
            @Mapping(source = "commissionRate", target = "promotionRate"),
            @Mapping(source = "pictUrl", target = "goodsImageUrl"),
            @Mapping(source = "volume", target = "salesTip"),
            @Mapping(source = "couponAmount", target = "couponDiscount", qualifiedByName = "convertMoneyUp"),
            @Mapping(source = "couponStartFee", target = "couponMinOrderAmount", qualifiedByName = "convertMoneyUp"),
            @Mapping(source = "couponTotalCount", target = "couponTotalQuantity"),
            @Mapping(source = "title", target = "goodsName"),
            @Mapping(source = "itemId", target = "goodsId"),
            @Mapping(source = "smallImages", target = "goodsGalleryUrls"),
            @Mapping(source = "smallImages", target = "goodsThumbnailUrl"),
            @Mapping(source = "couponRemainCount", target = "couponRemainQuantity"),
            @Mapping(source = "itemDescription", target = "goodsDesc"),
            @Mapping(source = "reservePrice", target = "minNormalPrice", qualifiedByName = "convertMoneyUp"),
            @Mapping(source = "zkFinalPrice", target = "minGroupPrice", qualifiedByName = "convertMoneyUp"),
    })
    GoodsDetailDTO tbVOToDTO(TBGoodsDetailVO item);


    GoodsListDTO tbVOToDTO(TBGoodsRecommendVO listVO);

    @Mappings({
            @Mapping(source = "resultList", target = "records"),
            @Mapping(source = "totalResults", target = "total"),
    })
    GoodsListDTO tbVOToSearchDTO(TBGoodsSearchVO listVO);
}
