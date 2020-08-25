package com.colia.yorik.common.interfaces.requestBody;


import com.colia.yorik.common.infrastructure.exception.ValidateException;

/**
 * 指令参数验证错误
 *
 * @Author colia
 * @Date 2020/7/16 下午6:55
 **/
public class CommandValidateException extends ValidateException {

    public CommandValidateException(String message) {
        super(message);
    }

    public CommandValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}