
package com.colia.yorik.common.infrastructure.exception;

/**
 * 业务异常,用于需要根据异常来写硬编码的业务操作,例如：业务状态不一致，期望上层系统做处理的异常
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
public class BizException extends Exception {

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}