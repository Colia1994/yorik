package com.colia.yorik.yorikweb.interfaces.order.facade.adapter;

import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.yorikweb.interfaces.order.facade.dto.OrderListDTO;
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
