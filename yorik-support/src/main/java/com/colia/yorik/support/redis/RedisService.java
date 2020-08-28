package com.colia.yorik.support.redis;

import org.springframework.stereotype.Service;

/**
 * @Author colia
 * @Date 2019/1/6 23:54
 */
@Service
public interface RedisService {

    void set(String str, String value);

    void set(String str, String value, long time);

    String get(String str);


}
