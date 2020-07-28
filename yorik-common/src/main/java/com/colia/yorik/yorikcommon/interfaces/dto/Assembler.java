package com.colia.yorik.yorikcommon.interfaces.dto;


/**
 * 数据传输对象装配器
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
public interface Assembler<T extends BaseDTO> {

    T toDTO(Object objects);

}
