package com.colia.yorik.application.order.valueObject;

import com.colia.yorik.common.domain.vo.ValueObject;
import lombok.Data;

import java.util.List;

/**
 * pdd 增量订单列表
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Data
public class PddOrderIncListVO implements ValueObject<PddOrderIncListVO> {

    /**
     * 总数
     */
    private Integer totalCount;

    /**
     * 多多进宝推广位对象列表
     */
    private List<PddOrderVO> orderList;

    @Override
    public boolean sameValueAs(PddOrderIncListVO other) {
        return false;
    }
}
