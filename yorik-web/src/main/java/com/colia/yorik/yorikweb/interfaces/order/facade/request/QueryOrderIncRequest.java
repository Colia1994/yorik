package com.colia.yorik.yorikweb.interfaces.order.facade.request;

import com.colia.yorik.yorikcommon.interfaces.requestBody.CommonCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单增量查询 请求参数
 *
 * @Author konglingyao
 * @Date 2020/7/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class QueryOrderIncRequest extends CommonCommand {


    @ApiModelProperty(value = "开始时间", required = true, example = "2020-07-01 00:00:00")
    private String startTime;
    @ApiModelProperty(value = "截止时间", required = true, example = "2020-08-01 00:00:00")
    private String endTime;
    @ApiModelProperty("页码")
    private Integer page;
    @ApiModelProperty(value = "每页数目", example = "40")
    private Integer pageSize;


    /**
     * 指令验证
     */
    @Override
    public void validate() {

    }
}
