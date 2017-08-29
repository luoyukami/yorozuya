package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.User;

/**
 * 前台用户账户相关操作类：注册、登陆、修改用户信息等
 *
 * @author ganxiang20970
 *         2017-08-15 21:59
 */
public interface UserAccountController {

    /**
     * 注册页面初始化
     * 可废弃
     */
    String signUpInit();

    /**
     * 用户注册
     * @param user 表单提交的用户信息
     */
    String signUp(User user);

    /**
     * 用户登录
     * @param name 用户名
     * @param password
     * @return
     */
    String signIn(String name, String password);

    String signOut();

}
