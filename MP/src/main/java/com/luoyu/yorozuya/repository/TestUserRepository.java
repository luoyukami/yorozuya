package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试用
 *
 * @author ganxiang20970
 *         2017-08-09 22:08
 */
@Repository(value = "testUserRepository")
public interface TestUserRepository extends JpaRepository<TestUser, Long>{

    List<TestUser> findBySex(Character sex);

    TestUser findByNameAndSex(String name, Character sex);

    @Query("select u from TestUser u where u.name=:name And u.sex=:sex")
    TestUser withNameAndSexQuery(@Param("name") String name, @Param("sex") Character sex);


}
