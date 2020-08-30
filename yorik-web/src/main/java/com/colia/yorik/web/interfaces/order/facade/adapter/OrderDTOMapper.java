package com.colia.yorik.web.interfaces.order.facade.adapter;

import com.colia.yorik.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.web.interfaces.order.facade.dto.OrderListDTO;
import org.mapstruct.Mapper;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Mapper(componentModel = "spring")
public interface OrderDTOMapper {

    OrderListDTO toOrderListDTO(PddOrderRangeListVO listVO);

    OrderListDTO toOrderListDTO(PddOrderIncListVO listVO);
}
