package com.colia.yorik.yoriksupport.aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author konglingyao
 * @Date 2020/7/22
 */
@Slf4j
@Data
public class ServiceProxyFactoryBean<T> implements InvocationHandler, FactoryBean<T> {

    private Class<?> interfaces;

    private Object obj;

    public String queue;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke doing");
        method.invoke(obj, args);
        System.out.println("invoke doing");
        return queue;
    }

    @Override
    public T getObject() throws Exception {
        log.info("queue:{},interfaces:{},{},{}", getQueue(), interfaces.getCanonicalName(), interfaces.getName(), interfaces.getSimpleName());
        System.out.println("queue:" + getQueue());
        log.info("准备构建代理类");
        System.out.println("准备构建代理类");
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{interfaces}, this);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }
}
