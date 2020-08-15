package com.colia.yorik.yorikcommon.interfaces.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动加入redis的注解
 *
 * @Author konglingyao
 * @Date 2020/8/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisAuto {

    String prefixKey();

    long minute() default 10;


}
