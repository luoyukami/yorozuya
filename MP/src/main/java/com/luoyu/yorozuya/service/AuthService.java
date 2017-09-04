package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.User;

/**
 * Created by 落羽 on 2017/9/1.
 */
public interface AuthService {
    User register(User userToAdd) throws Exception;
    String login(String username, String password);
    String refresh(String oldToken) throws Exception;
    void logout();
}
