package com.colia.yorik.yorikweb.interfaces.order.facade.adapter;

import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderVO;
import com.colia.yorik.yorikweb.interfaces.order.facade.dto.OrderDetailDTO;
import com.colia.yorik.yorikweb.interfaces.order.facade.dto.OrderListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-27T21:28:54+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class OrderDTOMapperImpl implements OrderDTOMapper {

    @Override
    public OrderListDTO toOrderListDTO(PddOrderRangeListVO listVO) {
        if ( listVO == null ) {
            return null;
        }

        OrderListDTO orderListDTO = new OrderListDTO();

        orderListDTO.setLastOrderId( listVO.getLastOrderId() );
        orderListDTO.setOrderList( pddOrderVOListToOrderDetailDTOList( listVO.getOrderList() ) );

        return orderListDTO;
    }

    @Override
    public OrderListDTO toOrderListDTO(PddOrderIncListVO listVO) {
        if ( listVO == null ) {
            return null;
        }

        OrderListDTO orderListDTO = new OrderListDTO();

        orderListDTO.setTotalCount( listVO.getTotalCount() );
        orderListDTO.setOrderList( pddOrderVOListToOrderDetailDTOList( listVO.getOrderList() ) );

        return orderListDTO;
    }

    protected OrderDetailDTO pddOrderVOToOrderDetailDTO(PddOrderVO pddOrderVO) {
        if ( pddOrderVO == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setCpaNew( pddOrderVO.getCpaNew() );
        orderDetailDTO.setCustomParameters( pddOrderVO.getCustomParameters() );
        orderDetailDTO.setFailReason( pddOrderVO.getFailReason() );
        orderDetailDTO.setGoodsId( pddOrderVO.getGoodsId() );
        orderDetailDTO.setGoodsName( pddOrderVO.getGoodsName() );
        orderDetailDTO.setGoodsPrice( pddOrderVO.getGoodsPrice() );
        orderDetailDTO.setGoodsQuantity( pddOrderVO.getGoodsQuantity() );
        orderDetailDTO.setGoodsThumbnailUrl( pddOrderVO.getGoodsThumbnailUrl() );
        orderDetailDTO.setOrderAmount( pddOrderVO.getOrderAmount() );
        orderDetailDTO.setOrderCreateTime( pddOrderVO.getOrderCreateTime() );
        orderDetailDTO.setOrderGroupSuccessTime( pddOrderVO.getOrderGroupSuccessTime() );
        orderDetailDTO.setOrderModifyAt( pddOrderVO.getOrderModifyAt() );
        orderDetailDTO.setOrderPayTime( pddOrderVO.getOrderPayTime() );
        orderDetailDTO.setOrderSn( pddOrderVO.getOrderSn() );
        orderDetailDTO.setOrderStatus( pddOrderVO.getOrderStatus() );
        orderDetailDTO.setOrderStatusDesc( pddOrderVO.getOrderStatusDesc() );
        orderDetailDTO.setOrderVerifyTime( pddOrderVO.getOrderVerifyTime() );
        orderDetailDTO.setPromotionAmount( pddOrderVO.getPromotionAmount() );
        orderDetailDTO.setPromotionRate( pddOrderVO.getPromotionRate() );
        orderDetailDTO.setPId( pddOrderVO.getPId() );
        orderDetailDTO.setType( pddOrderVO.getType() );
        List<Long> list = pddOrderVO.getCatIds();
        if ( list != null ) {
            orderDetailDTO.setCatIds( new ArrayList<Long>( list ) );
        }
        orderDetailDTO.setAuthDuoId( pddOrderVO.getAuthDuoId() );
        orderDetailDTO.setBatchNo( pddOrderVO.getBatchNo() );
        orderDetailDTO.setGroupId( pddOrderVO.getGroupId() );
        orderDetailDTO.setOrderReceiveTime( pddOrderVO.getOrderReceiveTime() );
        orderDetailDTO.setOrderSettleTime( pddOrderVO.getOrderSettleTime() );
        orderDetailDTO.setZsDuoId( pddOrderVO.getZsDuoId() );
        orderDetailDTO.setIsDirect( pddOrderVO.getIsDirect() );

        return orderDetailDTO;
    }

    protected List<OrderDetailDTO> pddOrderVOListToOrderDetailDTOList(List<PddOrderVO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetailDTO> list1 = new ArrayList<OrderDetailDTO>( list.size() );
        for ( PddOrderVO pddOrderVO : list ) {
            list1.add( pddOrderVOToOrderDetailDTO( pddOrderVO ) );
        }

        return list1;
    }
}
