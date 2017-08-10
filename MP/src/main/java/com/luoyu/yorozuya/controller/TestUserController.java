package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.TestUser;
import com.luoyu.yorozuya.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试用
 *
 * @author ganxiang20970
 *         2017-08-09 22:29
 */
@RestController
public class TestUserController {

    @Autowired
    TestUserService testUserService;

    @RequestMapping("/add")
    public TestUser add(String name, Integer age, Character sex){
        TestUser user = new TestUser(name, age, sex);
        return testUserService.addUser(user);
    }

    @RequestMapping("/queryUserBySex")
    public List<TestUser> queryUserBySex(Character sex) {
        return testUserService.queryUserBySex(sex);
    }

}
