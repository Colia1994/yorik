package com.colia.yorik.web.infrastructure.config;

import org.springframework.http.HttpHeaders;

/**
 * @Author konglingyao
 * @Date 2020/10/9
 */
public class HttpHeader {

    public static HttpHeaders buildResponseJsonHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json;charset=UTF-8");
        return responseHeaders;
    }
}