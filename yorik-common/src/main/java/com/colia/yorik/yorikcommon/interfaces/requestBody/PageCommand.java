package com.colia.yorik.yorikcommon.interfaces.requestBody;

import com.colia.yorik.yorikcommon.interfaces.Constants;
import lombok.Data;

/**
 * 分页指令请求参数
 *
 * @Author colia
 * @Date 2020/7/16 下午6:55
 **/
@Data
public abstract class PageCommand implements RequestCommand {

    /**
     * 页码
     */
    private Integer pageNo = Constants.DEFAULT_PAGE_NO;

    /**
     * 每页行数
     */
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
}