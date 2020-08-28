package com.colia.yorik.support.aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author konglingyao
 * @Date 2020/7/22
 */
@Slf4j
@Data
public class ProxyInterceptor implements InvocationHandler {


    public String queue;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke doing");
        return queue;
    }
}
