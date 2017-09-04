package com.luoyu.yorozuya.pojo;

/**
 * Created by 落羽 on 2017/9/1.
 * 请求token时发的内容
 */
public class TokenAuthenticationRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
