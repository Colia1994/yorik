package com.colia.yorik.yorikweb.interfaces.order.facade;

import com.colia.yorik.yorikweb.interfaces.order.facade.dto.OrderListDTO;
import com.colia.yorik.yorikapplication.application.order.request.QueryOrderIncRequest;
import com.colia.yorik.yorikapplication.application.order.request.QueryOrderRangeRequest;

/**
 * 订单查询防腐层
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
public interface OrderQueryFacade {

    /**
     * 按时间查询推广订单 防腐
     *
     * @param params 前台请求参数
     * @return 订单列表
     */
    OrderListDTO queryOrderByTimeRange(QueryOrderRangeRequest params);

    /**
     * 按时间查询增量订单
     *
     * @param params 前台请求参数
     * @return 订单列表
     */
    OrderListDTO queryIncOrderList(QueryOrderIncRequest params);
}
