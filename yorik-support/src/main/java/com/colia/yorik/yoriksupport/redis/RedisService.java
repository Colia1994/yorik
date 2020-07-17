package com.colia.yorik.yoriksupport.redis;

import org.springframework.stereotype.Service;

/**
 * @Author colia
 * @Date 2019/1/6 23:54
 */
@Service
public interface RedisService {

    void set(String str, String value);

    String get(String str);
}
