package com.luoyu.yorozuya.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 落羽 on 2017/8/17.
 */
@Entity
public class UserSignUp {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;

    public UserSignUp(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
