package com.colia.yorik.yorikcommon.interfaces.command;

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

}