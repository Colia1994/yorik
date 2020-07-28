package com.colia.yorik.yorikapplication.application.order;

import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderRangeListVO;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOrderListIncrementGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOrderListRangeGetRequest;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
public interface PddOrderService {


    /**
     * 根据订单支付时间范围查询我的推广订单
     *
     * @param request 时间范围
     * @return 订单集合
     */
    PddOrderRangeListVO queryOrderByTimeRange(PddDdkOrderListRangeGetRequest request);


    /**
     * 查询订单增量数据
     *
     * @param request 增量时间范围
     * @return 订单列表
     */
    PddOrderIncListVO queryOrderIncList(PddDdkOrderListIncrementGetRequest request);

}