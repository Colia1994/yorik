package com.colia.yorik.support.aop.aspectj;


import com.colia.yorik.common.interfaces.annotation.RedisAuto;
import com.colia.yorik.support.redis.RedisService;
import com.colia.yorik.support.utils.JSONUtil;
import com.colia.yorik.support.utils.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * redis  aspect
 *
 * @Author konglingyao
 * @Date 2020/8/11
 **/
@Aspect
@Component
@Slf4j
public class RedisAutoAspect {

    @Resource
    private RedisService redisService;

    @Around(value = "@annotation(com.colia.yorik.common.interfaces.annotation.RedisAuto)")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature joinPointObject = (MethodSignature) pjp.getSignature();

        Method method = joinPointObject.getMethod();
        RedisAuto redisAuto = method.getAnnotation(RedisAuto.class);

        String prefixKey = redisAuto.prefixKey();
        long minutes = redisAuto.minute();
        String key = prefixKey + JSONUtil.transferToJson(pjp.getArgs());
        log.info("redis-key:" + key);
        String value = redisService.get(key);
        if (StringUtils.isNotBlack(value)) {
            // 不执行方法体 直接返回
            redisService.set(key, value, minutes);
            return JSONUtil.transferToObj(value, method.getReturnType());
        } else {
            Object res = pjp.proceed();
            redisService.set(key, JSONUtil.transferToJson(res), minutes);
            return res;
        }

    }


}
