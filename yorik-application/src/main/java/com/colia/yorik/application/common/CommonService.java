package com.colia.yorik.application.common;

import java.util.concurrent.CompletableFuture;

/**
 * @Author konglingyao
 * @Date 2021/2/7
 */
public interface CommonService {

    CompletableFuture<String> saveDailyBmpParam(String yesy);
}
