package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.UserSignUp;
import com.luoyu.yorozuya.repository.UserSignUpRepository;
import com.luoyu.yorozuya.vo.TestJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 落羽 on 2017/8/17.
 */
@Service
public class UserSignUpService {

    @Autowired
    private UserSignUpRepository userSignUpRepository;

    public UserSignUp signUp(UserSignUp usp){ return userSignUpRepository.save(usp); }

    public TestJsonVo changeJson(TestJsonVo tsv) {
        tsv.getHobby().setGame("dota2");
        return tsv;
    }
}
