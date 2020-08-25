package com.colia.yorik.common.interfaces.ajaxresult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author colia
 * @Date 2020/7/16 下午6:55
 **/
@Data
@ApiModel(description = "返回结果")
public class AjaxResponse<T> {

    @ApiModelProperty("是否成功: true or false")
    private boolean success;

    @ApiModelProperty("描述性原因")
    private String msg = "操作成功！";


    private T data;


    protected AjaxResponse(boolean success) {
        this.success = success;
    }
}