package com.colia.yorik.application.promotion.valueObject;

import com.colia.yorik.support.domain.vo.ValueObject;
import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Data
public class PddPromotionVO implements ValueObject<PddPromotionVO> {


    @JsonProperty("create_time")
    private Long createTime;

    @JsonProperty("pid_name")
    private String pidName;

    @JsonProperty("p_id")
    private String pId;

    @Override
    public boolean sameValueAs(PddPromotionVO other) {
        return false;
    }
}
