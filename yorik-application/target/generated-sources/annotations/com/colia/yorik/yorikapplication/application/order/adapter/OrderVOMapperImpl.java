package com.colia.yorik.yorikapplication.application.order.adapter;

import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListRangeGetResponse.OrderListGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListRangeGetResponse.OrderListGetResponseOrderListItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-28T01:14:23+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class OrderVOMapperImpl implements OrderVOMapper {

    @Override
    public PddOrderRangeListVO toOrderRangeVO(OrderListGetResponse listVo) {
        if ( listVo == null ) {
            return null;
        }

        PddOrderRangeListVO pddOrderRangeListVO = new PddOrderRangeListVO();

        pddOrderRangeListVO.setLastOrderId( listVo.getLastOrderId() );
        pddOrderRangeListVO.setOrderList( orderListGetResponseOrderListItemListToPddOrderVOList( listVo.getOrderList() ) );

        return pddOrderRangeListVO;
    }

    @Override
    public PddOrderVO toOrderVO(OrderListGetResponseOrderListItem item) {
        if ( item == null ) {
            return null;
        }

        PddOrderVO pddOrderVO = new PddOrderVO();

        pddOrderVO.setCpaNew( item.getCpaNew() );
        pddOrderVO.setCustomParameters( item.getCustomParameters() );
        pddOrderVO.setFailReason( item.getFailReason() );
        pddOrderVO.setGoodsId( item.getGoodsId() );
        pddOrderVO.setGoodsName( item.getGoodsName() );
        pddOrderVO.setGoodsPrice( item.getGoodsPrice() );
        pddOrderVO.setGoodsQuantity( item.getGoodsQuantity() );
        pddOrderVO.setGoodsThumbnailUrl( item.getGoodsThumbnailUrl() );
        pddOrderVO.setOrderAmount( item.getOrderAmount() );
        pddOrderVO.setOrderCreateTime( item.getOrderCreateTime() );
        pddOrderVO.setOrderGroupSuccessTime( item.getOrderGroupSuccessTime() );
        pddOrderVO.setOrderModifyAt( item.getOrderModifyAt() );
        pddOrderVO.setOrderPayTime( item.getOrderPayTime() );
        pddOrderVO.setOrderSn( item.getOrderSn() );
        pddOrderVO.setOrderStatus( item.getOrderStatus() );
        pddOrderVO.setOrderStatusDesc( item.getOrderStatusDesc() );
        pddOrderVO.setOrderVerifyTime( item.getOrderVerifyTime() );
        pddOrderVO.setPromotionAmount( item.getPromotionAmount() );
        pddOrderVO.setPromotionRate( item.getPromotionRate() );
        pddOrderVO.setPId( item.getPId() );
        pddOrderVO.setType( item.getType() );
        List<Long> list = item.getCatIds();
        if ( list != null ) {
            pddOrderVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddOrderVO.setAuthDuoId( item.getAuthDuoId() );
        pddOrderVO.setBatchNo( item.getBatchNo() );
        pddOrderVO.setGroupId( item.getGroupId() );
        pddOrderVO.setOrderReceiveTime( item.getOrderReceiveTime() );
        pddOrderVO.setOrderSettleTime( item.getOrderSettleTime() );
        pddOrderVO.setZsDuoId( item.getZsDuoId() );
        pddOrderVO.setIsDirect( item.getIsDirect() );

        return pddOrderVO;
    }

    @Override
    public PddOrderIncListVO toOrderIncVO(com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse.OrderListGetResponse listVo) {
        if ( listVo == null ) {
            return null;
        }

        PddOrderIncListVO pddOrderIncListVO = new PddOrderIncListVO();

        if ( listVo.getTotalCount() != null ) {
            pddOrderIncListVO.setTotalCount( listVo.getTotalCount().intValue() );
        }
        pddOrderIncListVO.setOrderList( orderListGetResponseOrderListItemListToPddOrderVOList1( listVo.getOrderList() ) );

        return pddOrderIncListVO;
    }

    protected List<PddOrderVO> orderListGetResponseOrderListItemListToPddOrderVOList(List<OrderListGetResponseOrderListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddOrderVO> list1 = new ArrayList<PddOrderVO>( list.size() );
        for ( OrderListGetResponseOrderListItem orderListGetResponseOrderListItem : list ) {
            list1.add( toOrderVO( orderListGetResponseOrderListItem ) );
        }

        return list1;
    }

    protected PddOrderVO orderListGetResponseOrderListItemToPddOrderVO(com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse.OrderListGetResponseOrderListItem orderListGetResponseOrderListItem) {
        if ( orderListGetResponseOrderListItem == null ) {
            return null;
        }

        PddOrderVO pddOrderVO = new PddOrderVO();

        pddOrderVO.setCpaNew( orderListGetResponseOrderListItem.getCpaNew() );
        pddOrderVO.setCustomParameters( orderListGetResponseOrderListItem.getCustomParameters() );
        pddOrderVO.setFailReason( orderListGetResponseOrderListItem.getFailReason() );
        pddOrderVO.setGoodsId( orderListGetResponseOrderListItem.getGoodsId() );
        pddOrderVO.setGoodsName( orderListGetResponseOrderListItem.getGoodsName() );
        pddOrderVO.setGoodsPrice( orderListGetResponseOrderListItem.getGoodsPrice() );
        pddOrderVO.setGoodsQuantity( orderListGetResponseOrderListItem.getGoodsQuantity() );
        pddOrderVO.setGoodsThumbnailUrl( orderListGetResponseOrderListItem.getGoodsThumbnailUrl() );
        pddOrderVO.setOrderAmount( orderListGetResponseOrderListItem.getOrderAmount() );
        pddOrderVO.setOrderCreateTime( orderListGetResponseOrderListItem.getOrderCreateTime() );
        pddOrderVO.setOrderGroupSuccessTime( orderListGetResponseOrderListItem.getOrderGroupSuccessTime() );
        pddOrderVO.setOrderModifyAt( orderListGetResponseOrderListItem.getOrderModifyAt() );
        pddOrderVO.setOrderPayTime( orderListGetResponseOrderListItem.getOrderPayTime() );
        pddOrderVO.setOrderSn( orderListGetResponseOrderListItem.getOrderSn() );
        pddOrderVO.setOrderStatus( orderListGetResponseOrderListItem.getOrderStatus() );
        pddOrderVO.setOrderStatusDesc( orderListGetResponseOrderListItem.getOrderStatusDesc() );
        pddOrderVO.setOrderVerifyTime( orderListGetResponseOrderListItem.getOrderVerifyTime() );
        pddOrderVO.setPromotionAmount( orderListGetResponseOrderListItem.getPromotionAmount() );
        pddOrderVO.setPromotionRate( orderListGetResponseOrderListItem.getPromotionRate() );
        pddOrderVO.setPId( orderListGetResponseOrderListItem.getPId() );
        pddOrderVO.setType( orderListGetResponseOrderListItem.getType() );
        List<Long> list = orderListGetResponseOrderListItem.getCatIds();
        if ( list != null ) {
            pddOrderVO.setCatIds( new ArrayList<Long>( list ) );
        }
        pddOrderVO.setAuthDuoId( orderListGetResponseOrderListItem.getAuthDuoId() );
        pddOrderVO.setBatchNo( orderListGetResponseOrderListItem.getBatchNo() );
        pddOrderVO.setGroupId( orderListGetResponseOrderListItem.getGroupId() );
        pddOrderVO.setOrderReceiveTime( orderListGetResponseOrderListItem.getOrderReceiveTime() );
        pddOrderVO.setOrderSettleTime( orderListGetResponseOrderListItem.getOrderSettleTime() );
        pddOrderVO.setZsDuoId( orderListGetResponseOrderListItem.getZsDuoId() );
        pddOrderVO.setIsDirect( orderListGetResponseOrderListItem.getIsDirect() );

        return pddOrderVO;
    }

    protected List<PddOrderVO> orderListGetResponseOrderListItemListToPddOrderVOList1(List<com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse.OrderListGetResponseOrderListItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PddOrderVO> list1 = new ArrayList<PddOrderVO>( list.size() );
        for ( com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse.OrderListGetResponseOrderListItem orderListGetResponseOrderListItem : list ) {
            list1.add( orderListGetResponseOrderListItemToPddOrderVO( orderListGetResponseOrderListItem ) );
        }

        return list1;
    }
}
