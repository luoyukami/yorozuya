package com.luoyu.yorozuya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 * Created by 落羽 on 2017/9/1.
 * 用户的Token类
 */
public class TokenUser implements UserDetails{
    private final Long id;
    private final String username;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Timestamp lastPasswordResetDate;

    public TokenUser(
            Long id,
            String username,
            String password,
            String email,
            Collection<? extends GrantedAuthority> authorities,
            Timestamp lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
    // 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
