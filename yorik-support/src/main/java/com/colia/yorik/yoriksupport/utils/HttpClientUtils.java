package com.colia.yorik.yoriksupport.utils;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * http 连接 pdd
 *
 * @Author konglingyao
 * @Date 2020/7/23
 */
@Component
public class HttpClientUtils {

    @Value(value = "${pdd.clientId}")
    private String clientId;

    @Value(value = "${pdd.clientSecret}")
    private String clientSecret;

    @Value(value = "${taobao.appKey}")
    private String appKey;

    @Value(value = "${taobao.appSecret}")
    private String appSecret;

    @Value(value = "${taobao.httpUrl}")
    private String httpUrl;


    private static PopClient pddClient;

    private static TaobaoClient tbClient;

    private HttpClientUtils() {

    }

    @PostConstruct
    private void init() {
        pddClient = new PopHttpClient(clientId, clientSecret);
        tbClient = new DefaultTaobaoClient(httpUrl, appKey, appSecret);
    }

    //获取pdd 的client
    public static PopClient getPddClient() {
        return pddClient;
    }

    public static TaobaoClient getTBClient(){
        return tbClient;
    }


}
