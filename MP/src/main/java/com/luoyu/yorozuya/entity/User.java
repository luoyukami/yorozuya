package com.luoyu.yorozuya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 用户实体类
 *
 * @author ganxiang20970
 *         2017-08-08 22:04
 */
@Entity
public class User extends BaseEntity{

    private String name;//用户名
    private String password;//密码
    private Timestamp lastLoginTime;//上一次登陆时间
    private String lastIp;//上一次登陆的ip地址
    private String regType;//注册类型
    private String mobile;//电话
    private String email;//邮箱
    private String wechat;//微信
    private String userRoleId;//角色类型编号
    private String icon;//头像地址
    private Long operatorId;//操作员编号
    private String status;//用户状态

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    @Column(name = "reg_type")
    public String getRegType() {
        return regType;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    @Column(name = "user_role_id")
    public String getUserRoleId() {
        return userRoleId;
    }

    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    @Column(name = "operator_id")
    public Long getOperatorId() {
        return operatorId;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
