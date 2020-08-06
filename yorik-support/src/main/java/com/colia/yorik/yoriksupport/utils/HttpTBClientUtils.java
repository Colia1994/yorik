package com.colia.yorik.yoriksupport.utils;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author konglingyao
 * @Date 2020/8/6
 */
@Component
public class HttpTBClientUtils {


    private static String appKey;

    private static String appSecret;

    @Value(value = "${taobao.appKey}")
    public static void setAppKey(String appKey) {
        HttpTBClientUtils.appKey = appKey;
    }

    @Value(value = "${taobao.appSecret}")
    public static void setAppSecret(String appSecret) {
        HttpTBClientUtils.appSecret = appSecret;
    }

    private static class TaoBaoClients{
        private static TaobaoClient taobaoClient = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appKey, appSecret);
    }

    public static TaobaoClient getTBClient(String url) {
        return TaoBaoClients.taobaoClient;
    }
}
