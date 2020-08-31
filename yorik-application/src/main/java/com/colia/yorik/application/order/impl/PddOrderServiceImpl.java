package com.colia.yorik.application.order.impl;

import com.colia.yorik.application.order.PddOrderService;
import com.colia.yorik.application.order.adapter.OrderVOMapper;
import com.colia.yorik.application.order.request.QueryOrderIncRequest;
import com.colia.yorik.application.order.request.QueryOrderRangeRequest;
import com.colia.yorik.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.common.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.utils.DateUtils;
import com.colia.yorik.support.utils.HttpClientUtils;
import com.colia.yorik.support.utils.JSONUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOrderListIncrementGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOrderListRangeGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListIncrementGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOrderListRangeGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Slf4j
@Service
public class PddOrderServiceImpl implements PddOrderService {

    @Resource
    private OrderVOMapper orderMapper;

    /**
     * 根据订单支付时间范围查询我的推广订单
     *
     * @param params 时间范围
     * @return 订单集合
     */
    @Override
    public PddOrderRangeListVO queryOrderByTimeRange(QueryOrderRangeRequest params) {
        PopClient client = HttpClientUtils.getPddClient();
        //2019-05-07 00:00:00
        PddDdkOrderListRangeGetRequest request = new PddDdkOrderListRangeGetRequest();
        request.setStartTime(params.getStartTime());
        request.setEndTime(params.getEndTime());
        request.setLastOrderId(params.getLastOrderId());
        request.setPageSize(params.getPageSize());
        request.setPageSize(300);
        PddDdkOrderListRangeGetResponse response;
        try {
            log.info("queryOrderByTimeRange:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("queryOrderByTimeRange:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("queryOrderByTimeRange接口异常", e);
            throw new BizProcessException("queryOrderByTimeRange接口异常", e);
        }
        return orderMapper.toOrderRangeVO(response.getOrderListGetResponse());
    }

    /**
     * 查询订单增量数据
     *
     * @param params 增量时间范围
     * @return 订单列表
     */
    @Override
    public PddOrderIncListVO queryOrderIncList(QueryOrderIncRequest params) {
        PopClient client = HttpClientUtils.getPddClient();
        PddDdkOrderListIncrementGetRequest request = new PddDdkOrderListIncrementGetRequest();
        request.setStartUpdateTime(DateUtils.getTimeByDate(params.getStartTime()));
        request.setEndUpdateTime(DateUtils.getTimeByDate(params.getEndTime()));
        request.setPage(params.getPage());
        request.setPageSize(params.getPageSize());
        request.setReturnCount(Boolean.TRUE);
        PddDdkOrderListIncrementGetResponse response;

        try {
            log.info("queryOrderByTimeRange:请求参数:{}", JSONUtil.transferToString(request));
            response = client.syncInvoke(request);
            log.info("queryOrderByTimeRange:返回参数:{}", JSONUtil.transferToString(response));
        } catch (Exception e) {
            log.error("queryOrderIncList接口异常", e);
            throw new BizProcessException("queryOrderIncList接口异常", e);
        }
        return orderMapper.toOrderIncVO(response.getOrderListGetResponse());
    }
}
