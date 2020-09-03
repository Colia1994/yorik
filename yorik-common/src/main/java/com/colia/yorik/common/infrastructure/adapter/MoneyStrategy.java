package com.colia.yorik.common.infrastructure.adapter;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * adapter money 适配器
 * 暂时提供mapping struct使用
 *
 * @Author konglingyao
 * @Date 2020/9/3
 */
@Component
public class MoneyStrategy {

    /**
     * 金额向大转换 默认将传入值乘以100 转为分为单位的值
     *
     * @param value 元为单位的金额
     * @return 整形金额
     */
    @Named("convertMoneyUp")
    public Long convertMoneyUp(String value) {

        if (StringUtils.isBlank(value)) {
            return 0L;
        }
        BigDecimal res = new BigDecimal(value);
        res = res.multiply(new BigDecimal("100"));
        return res.longValue();
    }
}
