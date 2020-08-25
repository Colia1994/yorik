package com.colia.yorik.yorikweb.interfaces.goods.facade.adapter;

import com.colia.yorik.application.goods.valueObject.PddCatsVO;
import com.colia.yorik.yorikweb.interfaces.goods.facade.dto.GoodsCatsDTO;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/8/10
 */
@Mapper(componentModel = "spring")
public interface GoodsCommonMapper {

    GoodsCatsDTO pddToCatsDTO(PddCatsVO catsVO);
}
