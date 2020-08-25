package com.colia.yorik.application.order.valueObject;

import com.colia.yorik.common.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Data
public class PddOrderRangeListVO implements ValueObject<PddOrderRangeListVO> {

    /**
     * last_order_id
     */
    private String lastOrderId;

    /**
     * 多多进宝推广位对象列表
     */
    private List<PddOrderVO> orderList;

    @Override
    public boolean sameValueAs(PddOrderRangeListVO other) {
        return false;
    }
}
