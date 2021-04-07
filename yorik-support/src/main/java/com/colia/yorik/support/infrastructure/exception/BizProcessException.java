
package com.colia.yorik.support.infrastructure.exception;

/**
 * 业务处理异常，用于运行时处理的异常
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
public class BizProcessException extends RuntimeException {

    public BizProcessException(String message) {
        super(message);
    }

    public BizProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}