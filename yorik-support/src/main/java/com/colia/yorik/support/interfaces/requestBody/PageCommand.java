package com.colia.yorik.support.interfaces.requestBody;

import com.colia.yorik.support.interfaces.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页指令请求参数
 *
 * @Author colia
 * @Date 2020/7/16 下午6:55
 **/
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public abstract class PageCommand extends CommonCommand {

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo = Constants.DEFAULT_PAGE_NO;


    /**
     * 特殊标识页
     */
    @ApiModelProperty(value = "pdd翻页需要传入上一页返回的listId")
    private String listId;

    /**
     * 每页行数
     */
    @ApiModelProperty(value = "每页行数", example = "10")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;


}