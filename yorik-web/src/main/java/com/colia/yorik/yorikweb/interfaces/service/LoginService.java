package com.colia.yorik.yorikweb.interfaces.service;

/**
 * @Author colia
 * @Date 2019/1/9 21:33
 */
public interface LoginService {

    boolean signUp(String userName, String passWord);

    boolean signIn(String userName, String passWord);
}
