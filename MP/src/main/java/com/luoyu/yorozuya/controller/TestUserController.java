package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.TestUser;

import java.util.List;

/**
 * 测试用
 *
 * @author ganxiang20970
 *         2017-08-09 22:29
 */
public interface TestUserController {

    TestUser add(String name, Integer age, Character sex);

    List<TestUser> queryUserBySex(Character sex);

    List<TestUser> listAll();

    List<TestUser> findByNameAndSex(String name, Character sex);

    List<TestUser> queryByNameAndSex(String name, Character sex);

}
