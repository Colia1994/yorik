package com.colia.yorik.yorikweb.interfaces.goods.adapter;

import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsDetailVO;
import com.colia.yorik.yorikapplication.application.goods.valueObject.PddGoodsListVO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsDetailDTO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Author konglingyao
 * @Date 2020/7/24
 */
@Mapper(componentModel = "spring")
public interface GoodsDTOMapper {

    /**
     * 转换成通用商品dto
     *
     * @param item 推荐商品vo
     * @return 通用商品dto
     */
    GoodsDetailDTO pddVoToDto(PddGoodsDetailVO item);

    /**
     * 转换成通用商品dto
     *
     * @param listVO 推荐商品list
     * @return 通用商品分页dto
     */
    @Mappings({
            @Mapping(source = "list", target = "records"),
    })
    GoodsListDTO pddVoToDto(PddGoodsListVO listVO);
}
