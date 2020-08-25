package com.colia.yorik.common.interfaces.jenum;

public enum ErrorEnums {

    SYSTEM_ERROR("SYSTEM", "100", "系统错误"),
    USER_EXISTS("BUSINESS", "101", "用户已存在"),
    STATUS_ERROR("PARAMS", "102", "状态错误"),
    USER_NO_EXISTS("BUSINESS", "103", "用户不存在"),
    USER_IS_DISABLE("PARAMS", "104", "用户已被禁用"),
    GROUP_EXISTS("BUSINESS", "105", "工作组已存在"),

    PARAMS_IS_BLANK("PARAMS", "401", "参数为空"),
    PARAMS_IS_ILLEGAL("PARAMS", "402", "参数非法");


    private String type;

    private String code;

    private String msg;

    ErrorEnums(String type, String code, String msg) {
        this.type = type;
        this.code = code;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
