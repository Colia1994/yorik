
package com.colia.yorik.common.infrastructure.exception;

/**
 * 参数验证错误，用于数据约定性的异常处理
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
public class ValidateException extends RuntimeException {

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}