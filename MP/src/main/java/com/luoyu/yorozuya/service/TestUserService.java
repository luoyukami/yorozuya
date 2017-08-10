package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.TestUser;
import com.luoyu.yorozuya.repository.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 测试用
 *
 * @author ganxiang20970
 *         2017-08-09 22:34
 */
@Component
public class TestUserService {

    @Autowired
    TestUserRepository testUserRepository;

    public TestUser addUser(TestUser user) {
        return testUserRepository.save(user);
    }

    public List<TestUser> queryUserBySex(Character sex){
        return testUserRepository.findBySex(sex);
    }

}
