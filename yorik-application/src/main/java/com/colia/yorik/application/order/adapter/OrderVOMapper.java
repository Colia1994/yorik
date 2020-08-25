package com.colia.yorik.application.order.adapter;

import com.colia.yorik.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.application.order.valueObject.PddOrderVO;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListRangeGetResponse;
import org.mapstruct.Mapper;

/**
 * 订单转换mapper
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Mapper(componentModel = "spring")
public interface OrderVOMapper {

    PddOrderRangeListVO toOrderRangeVO(PddDdkOrderListRangeGetResponse.OrderListGetResponse listVo);

    PddOrderVO toOrderVO(PddDdkOrderListRangeGetResponse.OrderListGetResponseOrderListItem item);

    PddOrderIncListVO toOrderIncVO(PddDdkOrderListIncrementGetResponse.OrderListGetResponse listVo);


}
