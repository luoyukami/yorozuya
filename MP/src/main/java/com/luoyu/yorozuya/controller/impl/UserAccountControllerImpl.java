package com.luoyu.yorozuya.controller.impl;

import com.luoyu.yorozuya.controller.UserAccountController;
import com.luoyu.yorozuya.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台用户账户相关操作类：注册、登陆、修改用户信息等
 *
 * @author ganxiang20970
 *         2017-08-15 21:59
 */
@RequestMapping(name = "/userAccount")
public class UserAccountControllerImpl implements UserAccountController {


    @Override
    public String signUpInit() {
        return null;
    }

    @Override
    public String signUp(User user) {
        return null;
    }

    @Override
    public String signIn(String name, String password) {
        return null;
    }

    @Override
    public String signOut() {
        return null;
    }

}
