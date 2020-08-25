package com.colia.yorik.common.infrastructure.exception;

/**
 * json 异常
 *
 * @Author konglingyao
 * @Date 2020/7/31
 */
public class JsonParseException extends BizProcessException {


    public JsonParseException() {
        super("json parse error");
    }

    public JsonParseException(Throwable cause) {
        super("json parse error", cause);
    }
}
