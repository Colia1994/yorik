package com.colia.yorik.yoriksupport.redis.impl;

import com.colia.yorik.yoriksupport.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 操作类
 *
 * @Author colia
 * @Date 2019/1/6 23:54
 */
@Component
public class RedisServiceImpl implements RedisService {


    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @Override
    public void set(String str, String value) {
        stringRedisTemplate.opsForValue().set(str, value);
    }

    @Override
    public void set(String str, String value, long time) {
        stringRedisTemplate.opsForValue().set(str, value, time, TimeUnit.MINUTES);

    }

    @Override
    public String get(String str) {
        return stringRedisTemplate.opsForValue().get(str);
    }

}
