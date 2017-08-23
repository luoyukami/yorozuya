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

    @GetMapping(name = "/reg")
    public void userRegInit() {

    }

    @PostMapping(name = "/reg")
    public void userReg(User user) {

    }

    @GetMapping(name = "/login")
    public void userLogin(String name, String password) {

    }

}
