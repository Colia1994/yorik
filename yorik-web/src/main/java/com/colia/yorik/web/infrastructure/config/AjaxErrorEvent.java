package com.colia.yorik.web.infrastructure.config;

/**
 * 错误执行动作
 *
 * @Author konglingyao
 * @Date 2020/9/3
 **/
public enum AjaxErrorEvent {
    ALTER,
    REDIRECT,
    UNDO;

    private AjaxErrorEvent() {
    }
}