
package com.colia.yorik.support.interfaces.dto;


import com.colia.yorik.support.infrastructure.exception.BizProcessException;

/**
 * 数据传输对象装配器处理异常
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
public class AssemblerProcessException extends BizProcessException {

    public AssemblerProcessException(String message) {
        super(message);
    }

    public AssemblerProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}