package com.luoyu.yorozuya.utils;

import com.luoyu.yorozuya.entity.Role;
import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.TokenUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 落羽 on 2017/9/1.
 */
public final class TokenUserFactory {
    private TokenUserFactory() {
    }

    public static TokenUser create(User user) {
        return new TokenUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<Role> authorities) {
        return authorities.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
