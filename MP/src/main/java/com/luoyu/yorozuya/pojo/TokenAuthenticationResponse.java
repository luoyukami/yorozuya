package com.luoyu.yorozuya.pojo;

/**
 * Created by 落羽 on 2017/9/1.
 * 请求token时候 返回的内容
 */
public class TokenAuthenticationResponse {
    private String token;

    public TokenAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
