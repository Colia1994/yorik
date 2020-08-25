package com.colia.yorik.common.interfaces.requestBody;

import java.util.regex.Pattern;

/**
 * 指令验证器
 *
 * @Author colia
 * @Date 2020/7/16 下午6:55
 **/
public class CommandValidate {

    public static <T extends CharSequence> T notEmpty(final T chars, final String message, final Object... values) {
        if (chars == null) {
            throw new CommandValidateException(String.format(message, values));
        }
        if (chars.length() == 0) {
            throw new CommandValidateException(String.format(message, values));
        }
        return chars;
    }


    public static <T> T notNull(final T object, final String message, final Object... values) {
        if (object == null) {
            throw new CommandValidateException(String.format(message, values));
        }
        return object;
    }

    public static void matchesPattern(CharSequence input, String pattern) {
        if (!Pattern.matches(pattern, input)) {
            throw new CommandValidateException(String.format("The string %s does not match the pattern %s", input, pattern));
        }
    }

    public static void matchesPattern(CharSequence input, String pattern, String message, Object... values) {
        if (!Pattern.matches(pattern, input)) {
            throw new CommandValidateException(String.format(message, values));
        }
    }


}