package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.repository.RoleRepository;
import com.luoyu.yorozuya.repository.UserRepository;
import com.luoyu.yorozuya.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by 落羽 on 2017/9/1.
 * 用户验证实现类
 */
@Service
public class AuthServiceImpl implements AuthService{
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private TokenUtil tokenUtil;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            TokenUtil tokenUtil,
            UserRepository userRepository,
            RoleRepository roleRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenUtil = tokenUtil;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(User userToAdd) throws Exception {
        final String username = userToAdd.getUsername();
        if (userRepository.findByUsername(username) != null) {
            throw new Exception(String.format("register user \"%s\" failed: the same username is already exists!", username));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Timestamp(System.currentTimeMillis()));
        userToAdd.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        return userRepository.save(userToAdd);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = tokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        final String token = oldToken.substring(tokenHead.length());
        String username = tokenUtil.getUsernameFromToken(token);
        User user = (User) userDetailsService.loadUserByUsername(username);
        if (tokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return tokenUtil.refreshToken(token);
        }else {
            throw new Exception(String.format("refresh token \"%s\" failed: token can not be refreshed. ", oldToken));
        }
    }

    @Override
    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
