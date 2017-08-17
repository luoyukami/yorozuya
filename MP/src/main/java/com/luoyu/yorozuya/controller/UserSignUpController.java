package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.UserSignUp;
import com.luoyu.yorozuya.service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 落羽 on 2017/8/17.
 */
@RestController
@RequestMapping("/yorozuya")
public class UserSignUpController {

    @Autowired
    UserSignUpService userSignUpService;

    @GetMapping(value = "/signUp")
    public UserSignUp signUp(@RequestParam String name,
                             @RequestParam String password){
        UserSignUp userSignUp = new UserSignUp(name, password);
        return userSignUpService.signUp(userSignUp);
    }
}
