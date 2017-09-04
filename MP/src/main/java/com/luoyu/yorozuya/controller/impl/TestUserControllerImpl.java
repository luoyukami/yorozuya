package com.luoyu.yorozuya.controller.impl;

import com.luoyu.yorozuya.controller.TestUserController;
import com.luoyu.yorozuya.entity.TestUser;
import com.luoyu.yorozuya.service.TestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class TestUserControllerImpl implements TestUserController {
    Logger logger = LoggerFactory.getLogger(TestUserControllerImpl.class);

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

    @RequestMapping("/listALl")
    public List<TestUser> listAll() {
        return testUserService.listAll();
    }

    @RequestMapping("/find")
    public List<TestUser> findByNameAndSex(String name, Character sex) {
        return testUserService.findByNameAndSex(name, sex);
    }

    @RequestMapping("/query")
    public List<TestUser> queryByNameAndSex(String name, Character sex) {
        return testUserService.queryByNameAndSex(name, sex);
    }

}
