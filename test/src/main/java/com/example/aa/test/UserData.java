package com.example.aa.test;

/**
 * Created by 101 on 2016/4/12.
 */
public class UserData {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String username;
    private String token;
    private String pwd;
}
