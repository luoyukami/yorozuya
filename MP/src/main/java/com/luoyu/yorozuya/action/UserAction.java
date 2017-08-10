package com.luoyu.yorozuya.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 与用户相关的的Action类
 *
 * @author ganxiang20970
 *         2017-08-07 22:06
 */
@RequestMapping(name = "/user")
@Controller
public class UserAction {

    /**
     *
     * @return
     */
    @RequestMapping("/signIn")
    public String userSignIn() {
        return null;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String userSignUpInit() {
        return null;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String userSignUp() {
        return null;
    }

}
