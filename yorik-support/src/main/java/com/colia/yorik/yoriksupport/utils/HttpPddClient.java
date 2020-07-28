package com.colia.yorik.yoriksupport.utils;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author konglingyao
 * @Date 2020/7/23
 */
@Component
public class HttpPddClient {

    @Value(value = "${pdd.clientId}")
    private String clientId;

    @Value(value = "${pdd.clientSecret}")
    private String clientSecret;


    private static PopClient client;

    private HttpPddClient() {

    }

    @PostConstruct
    private void init() {
        client = new PopHttpClient(clientId, clientSecret);
    }

    //获取pdd 的client
    public static PopClient getPddClient() {
        return client;
    }


}
