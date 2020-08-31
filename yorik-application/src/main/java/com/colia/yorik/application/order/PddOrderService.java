package com.colia.yorik.application.order;

import com.colia.yorik.application.order.request.QueryOrderIncRequest;
import com.colia.yorik.application.order.request.QueryOrderRangeRequest;
import com.colia.yorik.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.application.order.valueObject.PddOrderRangeListVO;

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
    PddOrderRangeListVO queryOrderByTimeRange(QueryOrderRangeRequest request);


    /**
     * 查询订单增量数据
     *
     * @param request 增量时间范围
     * @return 订单列表
     */
    PddOrderIncListVO queryOrderIncList(QueryOrderIncRequest request);

}
