package com.colia.yorik.yorikapplication.application.order.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.CommonCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单范围查询 请求参数
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class QueryOrderRangeRequest extends CommonCommand {

    @ApiModelProperty(value = "开始时间", required = true, example = "2020-07-01 00:00:00")
    private String startTime;
    @ApiModelProperty(value = "截止时间", required = true, example = "2020-08-01 00:00:00")
    private String endTime;
    @ApiModelProperty(value = "第二页后传回上次的订单id（每次查询会返回）")
    private String lastOrderId;
    @ApiModelProperty(value = "每次查询数目", example = "300")
    private Integer pageSize;


    /**
     * 指令验证
     */
    @Override
    public void validate() {

    }
}
