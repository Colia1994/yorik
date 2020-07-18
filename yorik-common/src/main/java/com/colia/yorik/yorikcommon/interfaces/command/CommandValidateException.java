package com.colia.yorik.yorikcommon.interfaces.command;


import com.colia.yorik.yorikcommon.infrastructure.exception.ValidateException;

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