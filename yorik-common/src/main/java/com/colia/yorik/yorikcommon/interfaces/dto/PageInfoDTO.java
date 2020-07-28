
package com.colia.yorik.yorikcommon.interfaces.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页传输对象
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PageInfoDTO<T> extends BaseDTO {
    /**
     * 当前页为第几页
     */
    private Integer current = 1;

    /**
     * 特殊翻页页数
     */
    private String listId;

    /**
     * 总记录数
     */
    private Integer total = 0;
    /**
     * 返回的数据体
     */
    private List<T> records = new ArrayList<T>();
}