package com.colia.yorik.yorikcommon.interfaces.requestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 指令 验证通用请求
 *
 * @Author konglingyao
 * @Date 2020/8/9
 */
@ApiModel
@Data
public abstract class CommonCommand implements RequestCommand {

    /**
     * 数据源类型 1 pdd 2 淘宝
     */
    @ApiModelProperty("数据源类型 1 pdd 2 淘宝")
    private Integer sourceType = 1;
}
