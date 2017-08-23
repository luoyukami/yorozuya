package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.TestUser;
import com.luoyu.yorozuya.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public TestUser add(@RequestParam("name") String name,
                        @RequestParam("age") Integer age,
                        @RequestParam("sex") Character sex){
        TestUser user = new TestUser(name, age, sex);
        return testUserService.addUser(user);
    }

    @RequestMapping("/queryUserBySex")
    public List<TestUser> queryUserBySex(Character sex) {
        return testUserService.queryUserBySex(sex);
    }

    @RequestMapping("/listAll")
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
