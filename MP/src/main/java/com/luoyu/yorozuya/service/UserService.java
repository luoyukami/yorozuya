package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 *
 * @author ganxiang20970
 *         2017-08-07 22:14
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findUser(Integer pagesize){
       return userRepository.findAll(new PageRequest(0,pagesize));
    }

    public User findAUser(String name, String password){
        return userRepository.findAUser(name, password);
    }

    public int deleteUser(Integer id){
        return userRepository.deleteUser(id);
    }


}
