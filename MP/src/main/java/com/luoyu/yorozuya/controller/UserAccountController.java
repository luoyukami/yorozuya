package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.User;

/**
 * 前台用户账户相关操作类：注册、登陆、修改用户信息等
 *
 * @author ganxiang20970
 *         2017-08-15 21:59
 */
public interface UserAccountController {

    void userRegInit();

    /**
     *
     * @param user
     */
    void userReg(User user);

    void userLogin(String name, String password);

}
