package com.colia.yorik.yorikcommon.interfaces.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author colia
 * @Date 2020/07/15 下午3:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormInfoDTO<T> extends BaseDTO {

    private List<T> records = new ArrayList<T>();
}
