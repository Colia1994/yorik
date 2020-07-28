package com.colia.yorik.yorikapplication.application.promotion.valueObject;

import com.colia.yorik.yorikcommon.domain.vo.ValueObject;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Data
public class PromotionVO implements ValueObject<PromotionVO> {


    @JsonProperty("create_time")
    private Long createTime;

    @JsonProperty("pid_name")
    private String pidName;

    @JsonProperty("p_id")
    private String pId;

    @Override
    public boolean sameValueAs(PromotionVO other) {
        return false;
    }
}
