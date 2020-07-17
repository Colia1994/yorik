package com.colia.yorik.yorikweb.domain;

/**
 * @Author colia
 * @Date 2019/1/5 17:52
 */
public class User {


    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
