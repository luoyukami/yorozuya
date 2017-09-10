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

    @Column(name = "user_id", columnDefinition = "comment '用户编号'")
    private Long userId;

    @Column(name = "birthday", columnDefinition = "comment '用户生日'")
    private Date birthday;

    @Column(name = "sex", columnDefinition = "char(1) comment '用户性别'")
    private Character sex;

    @Column(name = "real_name", columnDefinition = "varchar(20) comment '用户真实姓名'")
    private String realName;

    @Column(name = "constellation", columnDefinition = "char(2) comment '用户星座'")
    private String constellation;

    public Long getUserId() {
        return userId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Character getSex() {
        return sex;
    }

    public String getRealName() {
        return realName;
    }

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
