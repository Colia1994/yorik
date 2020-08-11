package com.colia.yorik.yoriksupport.aop.aspectj;


import com.colia.yorik.yorikcommon.interfaces.annotation.RedisAuto;
import com.colia.yorik.yoriksupport.redis.RedisService;
import com.colia.yorik.yoriksupport.utils.JSONUtil;
import com.colia.yorik.yoriksupport.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    @Around(value = "@annotation(com.colia.yorik.yorikcommon.interfaces.annotation.RedisAuto)")
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
            redisService.set(key, value,minutes);
            return JSONUtil.transferToObj(value, method.getReturnType());
        } else {
            Object res = pjp.proceed();
            redisService.set(key, JSONUtil.transferToJson(res),minutes);
            return res;
        }

    }


}
