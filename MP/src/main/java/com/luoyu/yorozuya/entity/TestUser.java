package com.luoyu.yorozuya.entity;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * 测试用
 *
 * @author ganxiang20970
 *         2017-08-09 22:05
 */
@Entity
public class TestUser extends UUID{
//    @Id
//    @GeneratedValue
//    private Long id;
    private String name;
    private Integer age;
    private Character sex;

    public TestUser() {
    }



    public TestUser(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
