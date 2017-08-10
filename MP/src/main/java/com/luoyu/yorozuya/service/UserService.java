package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.repository.UserRepository;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;

/**
 * 用户业务实现类
 *
 * @author ganxiang20970
 *         2017-08-07 22:14
 */
public class UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    //public Page<User>
}
