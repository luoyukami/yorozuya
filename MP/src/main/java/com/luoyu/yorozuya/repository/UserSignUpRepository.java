package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.UserSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 落羽 on 2017/8/17.
 */
@Repository(value = "userSignUpRepository")
public interface UserSignUpRepository extends JpaRepository<UserSignUp, Long> {
}
