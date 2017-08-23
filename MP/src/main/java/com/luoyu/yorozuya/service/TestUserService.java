package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.TestUser;
import com.luoyu.yorozuya.repository.TestUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TestUserService.class);

    @Autowired
    TestUserRepository testUserRepository;

    public TestUser addUser(TestUser user) {
        return testUserRepository.save(user);
    }

    public List<TestUser> queryUserBySex(Character sex){
        logger.info("param sex = "+ sex);
        logger.error("一般在try catch中会加入error日志打印");
        logger.debug("debug日志一般用于调试");
        logger.warn("waring级别日志用的应该比较少");
        return testUserRepository.findBySex(sex);
    }

    public List<TestUser> listAll() {
        logger.error("==============error=================");
        return testUserRepository.findAll();
    }

    public List<TestUser> findByNameAndSex(String name, Character sex) {
        logger.info("=============findByNameAndSex===============");
        return testUserRepository.findByNameAndSex(name, sex);
    }

    public List<TestUser> queryByNameAndSex(String name, Character sex) {
        return testUserRepository.withNameAndSexQuery(name, sex);
    }

}
