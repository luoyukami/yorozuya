package com.luoyu.yorozuya.entity;

import javax.persistence.Column;
import java.sql.Date;

/**
 * 存放用户信息 - 拓展信息，如：用户性别、星座、血型等
 *
 * @author ganxiang20970
 *         2017-08-15 21:53
 */
public class UserInfo extends BaseEntity{

    private Long userId;
    private Date birthday;
    private Character sex;
    private String realName;
    private String constellation;

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    @Column(name = "sex")
    public Character getSex() {
        return sex;
    }

    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    @Column(name = "constellation")
    public String getConstellation() {
        return constellation;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
}
