package com.colia.yorik.support.utils;

/**
 * string工具类
 *
 * @Author colia
 * @Date 2017-07-18
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final String a = "IOS_8859_1";
    private static final String b = "GB2312";

    public static boolean isBlack(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlack(final CharSequence cs) {
        return !isBlack(cs);
    }

}
