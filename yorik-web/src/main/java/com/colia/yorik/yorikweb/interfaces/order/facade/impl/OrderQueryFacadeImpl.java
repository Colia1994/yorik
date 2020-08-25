package com.colia.yorik.yorikweb.interfaces.order.facade.impl;

import com.colia.yorik.application.order.PddOrderService;
import com.colia.yorik.application.order.request.QueryOrderIncRequest;
import com.colia.yorik.application.order.request.QueryOrderRangeRequest;
import com.colia.yorik.yorikweb.interfaces.order.facade.OrderQueryFacade;
import com.colia.yorik.yorikweb.interfaces.order.facade.adapter.OrderDTOMapper;
import com.colia.yorik.yorikweb.interfaces.order.facade.dto.OrderListDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单查询防腐层实现
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Service
public class OrderQueryFacadeImpl implements OrderQueryFacade {

    @Resource
    private OrderDTOMapper orderDTOMapper;

    @Resource
    private PddOrderService pddOrderService;


    /**
     * 按时间查询推广订单 防腐
     *
     * @param params 前台请求参数
     * @return 订单列表
     */
    @Override
    public OrderListDTO queryOrderByTimeRange(QueryOrderRangeRequest params) {

        return orderDTOMapper.toOrderListDTO(pddOrderService.queryOrderByTimeRange(params));
    }

    /**
     * 按时间查询增量订单
     *
     * @param params 前台请求参数
     * @return 订单列表
     */
    @Override
    public OrderListDTO queryIncOrderList(QueryOrderIncRequest params) {

        return orderDTOMapper.toOrderListDTO(pddOrderService.queryOrderIncList(params));
    }
}
