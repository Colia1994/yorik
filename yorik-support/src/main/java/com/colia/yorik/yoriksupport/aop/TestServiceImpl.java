package com.colia.yorik.yoriksupport.aop;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author konglingyao
 * @Date 2020/7/22
 */
@Slf4j
public class TestServiceImpl implements TestService {
    @Override
    public String doWork(String test) {
        log.info("impl doing");
        return "111:" + test;
    }
}
