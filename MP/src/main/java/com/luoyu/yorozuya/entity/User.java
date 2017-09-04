package com.luoyu.yorozuya.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luoyu.yorozuya.pojo.publicEnum.EnumUserRegType;
import com.luoyu.yorozuya.pojo.publicEnum.EnumUserStatus;
import com.luoyu.yorozuya.pojo.publicEnum.EnumUserType;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.SQLDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.*;

/**
 * 用户实体类
 *
 * @author ganxiang20970
 *         2017-08-08 22:04
 */
@Entity
@Table(name = "user")
@SQLDelete(sql = "Update user SET status = 'deleted' where id=?")
@Where(clause = "status != 'deleted'")
public class User extends BaseEntity implements UserDetails {

    private String username;//用户名
    private String password;//密码
    private Organization organization;//归属结构(例如：游戏区域闲聊版  操作权限和访问权限的判定之一)
    private Timestamp lastLoginTime;//上一次登陆时间
    private String lastIp;//上一次登陆的ip地址
    private EnumUserRegType regType;//注册类型
    private String mobile;//电话
    private String email;//邮箱
    private String wechat;//微信
    private EnumUserType userType;//用户类型(例如：音乐区资源版版主 操作权限和访问权限的判定之一)
    private String icon;//头像地址
    private User operator;//操作员
    private EnumUserStatus status;//用户状态
    private Set<Role> roles;//拥有角色列表
    private Timestamp lastPasswordResetDate;//最近的密码修改时间，用于配合token验证

    // 实现UsreDetails需要实现一些方法
    // 把用户的角色作为权限
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = this.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            for (Authority authority : role.getAuthorities()){
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
            }
        }
        return new HashSet<>(grantedAuthorities);
    }
    public Set<String> getAuthorityNames() {
        Set<String> authorityNames = new HashSet<>();
        Collection<Role> roles = this.getRoles();
        for (Role role : roles) {
            for (Authority authority : role.getAuthorities()) {
                authorityNames.add(authority.getName());
            }
        }
        return authorityNames;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return  true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Column(name = "name", columnDefinition = "char(20)")
//    @Override
    public String getUsername() {
        return username;
    }

    @Column(name = "password", columnDefinition = "varchar(256)")
//    @Override
    public String getPassword() {
        return password;
    }

    @ManyToOne
    @JoinColumn(name = "org_id")
    public Organization getOrganization() {
        return organization;
    }

    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    @Column(name = "last_ip", columnDefinition = "char(15)")
    public String getLastIp() {
        return lastIp;
    }

    @Column(name = "regType", columnDefinition = "char(10)")
    @Enumerated(EnumType.STRING)
    public EnumUserRegType getRegType() {
        return regType;
    }

    @Column(name = "mobile", columnDefinition = "char(13)")
    public String getMobile() {
        return mobile;
    }

    @Column(name = "email", columnDefinition = "char(64)")
    public String getEmail() {
        return email;
    }

    @Column(name = "wechat", columnDefinition = "char(64)")
    public String getWechat() {
        return wechat;
    }

    @Column(name = "user_type", columnDefinition = "char(30)")
    @Enumerated(EnumType.STRING)
    public EnumUserType getUserType() {
        return userType;
    }

    @Column(name = "icon", columnDefinition = "varchar(256)")
    public String getIcon() {
        return icon;
    }

    @ManyToOne
    @JoinColumn(name = "operator_id")
    public User getOperator() {
        return operator;
    }

    @Column(name = "status", columnDefinition = "char(10) default 'NORMAL'")
    public EnumUserStatus getStatus() {
        return status;
    }

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Collection<Role> getRoles() {
        return roles;
    }

    @Column(name = "last_pwd_reset_date")
    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setRegType(EnumUserRegType regType) {
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

    public void setUserType(EnumUserType userType) {
        this.userType = userType;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public void setStatus(EnumUserStatus status) {
        this.status = status;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
