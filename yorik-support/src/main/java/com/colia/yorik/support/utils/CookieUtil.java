package com.colia.yorik.support.utils;


import org.springframework.http.ResponseCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author konglingyao
 * @Date 2020/8/5
 */
public class CookieUtil {

    // 默认缓存时间,单位/秒, 2H
    private static final int COOKIE_MAX_AGE = Integer.MAX_VALUE;
    // 保存路径,根路径
    private static final String COOKIE_PATH = "/";


    /**
     * 保存
     *
     * @param response servlet
     * @param key
     * @param value
     * @param ifRemember
     */
    public static void set(HttpServletResponse response, String key, String value, boolean ifRemember) {

        int age = ifRemember ? COOKIE_MAX_AGE : -1;
        set(response, key, value, null, COOKIE_PATH, age, false);
    }

    /**
     * 保存
     *
     * @param response
     * @param key
     * @param value
     * @param maxAge
     */
    private static void set(HttpServletResponse response, String key, String value, String domain, String path, int maxAge, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }

        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(isHttpOnly);
        response.addCookie(cookie);

//        ResponseCookie cookie = ResponseCookie.from(key, value) // key & value
//                .httpOnly(false)		// 禁止js读取
//                .secure(true)		// 在http下也传输
////                .domain("localhost")// 域名
//                .path("/")			// path
//                .maxAge(maxAge)	// 1个小时候过期
//                .sameSite("None")	// 大多数情况也是不发送第三方 Cookie，但是导航到目标网址的 Get 请求除外
//                .build();
//
//        response.setHeader("Set-Cookie", cookie.toString());

    }

    /**
     * 查询value
     *
     * @param request
     * @param key
     * @return
     */
    public static String getValue(HttpServletRequest request, String key) {

        Cookie cookie = get(request, key);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

    /**
     * 查询Cookie
     *
     * @param request
     * @param key
     */
    private static Cookie get(HttpServletRequest request, String key) {
        Cookie[] arr_cookie = request.getCookies();
        if (arr_cookie != null && arr_cookie.length > 0) {
            for (Cookie cookie : arr_cookie) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     * @param key
     */
    public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = get(request, key);
        if (cookie != null) {
            set(response, key, "", null, COOKIE_PATH, 0, true);
        }
    }

}