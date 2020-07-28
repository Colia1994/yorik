package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsRecommendVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsSearchVO;
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

    /**
     * 转换成通用商品dto
     *
     * @param item 推荐商品vo
     * @return 通用商品dto
     */
    @Mappings({
            @Mapping(source = "goodsList", target = "records"),
            @Mapping(source = "totalCount", target = "total"),
    })
    GoodsListDTO pddVoToDto(PddGoodsSearchVO item);

    /**
     * 转换成通用商品dto
     *
     * @param listVO 推荐商品list
     * @return 通用商品分页dto
     */
    @Mappings({
            @Mapping(source = "list", target = "records"),
    })
    GoodsListDTO pddVoToDto(PddGoodsRecommendVO listVO);

    /**
     * 转换成通用商品详情dto
     *
     * @param item 商品详情vo
     * @return 商品详情dto
     */
    GoodsDetailDTO pddVoToDto(PddGoodsDetailVO item);
}
