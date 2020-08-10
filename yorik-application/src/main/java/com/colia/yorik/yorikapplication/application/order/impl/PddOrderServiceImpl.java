package com.colia.yorik.yorikapplication.application.order.impl;

import com.colia.yorik.yorikapplication.application.order.PddOrderService;
import com.colia.yorik.yorikapplication.application.order.adapter.OrderVOMapper;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderIncListVO;
import com.colia.yorik.yorikapplication.application.order.valueObject.PddOrderRangeListVO;
import com.colia.yorik.yorikcommon.infrastructure.exception.BizProcessException;
import com.colia.yorik.yoriksupport.utils.HttpClientUtils;
import com.colia.yorik.yoriksupport.utils.JSONUtil;
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
     * @param request 时间范围
     * @return 订单集合
     */
    @Override
    public PddOrderRangeListVO queryOrderByTimeRange(PddDdkOrderListRangeGetRequest request) {
        PopClient client = HttpClientUtils.getPddClient();
        //2019-05-07 00:00:00
        //暂时写死
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
     * @param request 增量时间范围
     * @return 订单列表
     */
    @Override
    public PddOrderIncListVO queryOrderIncList(PddDdkOrderListIncrementGetRequest request) {
        PopClient client = HttpClientUtils.getPddClient();

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
