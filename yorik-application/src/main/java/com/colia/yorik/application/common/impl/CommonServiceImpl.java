package com.colia.yorik.application.common.impl;

import com.colia.yorik.application.common.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author konglingyao
 * @Date 2021/2/7
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    @Async("defaultExecutor")
    @Override
    public CompletableFuture<String> saveDailyBmpParam(String yesy) {
        Thread t = Thread.currentThread();
        log.info(t.getName() + "：开始执行，文本{}", yesy);
        try {
            Thread.sleep(5000);
            log.info(t.getName() + "：执行完毕，文本{}", yesy);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(yesy);
    }
}
