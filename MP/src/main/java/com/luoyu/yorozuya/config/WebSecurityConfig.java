package com.luoyu.yorozuya.config;

import com.luoyu.yorozuya.filter.AuthenticationTokenFilter;
import com.luoyu.yorozuya.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by 落羽 on 2017/8/29.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                // 使用BCrypt
                .passwordEncoder(passwordEncoder());
    }

    // 装载BCrypt编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new AuthenticationTokenFilter();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 添加token过滤
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity
                // 使用的jwt 不需要csrf(跨站脚本攻击)的模块
                .csrf().disable()
                // 也不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 设置options请求无授权访问
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 允许GET请求的无授权访问(静态资源)
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/assets/**",
                        "/**/*.ttf",
                        "/**/*.woff*"
                ).permitAll()
                // 用户和菜单接口开放
                .antMatchers("/user/**", "/menu/**").permitAll()
                // 请求token的验证接口开放
                .antMatchers(
                        HttpMethod.POST,
                        "/auth", "/auth/register"
                ).permitAll()
                // 其余的需要验证
                .anyRequest().authenticated();

//        // 禁用缓存(还是不禁用了)
//        httpSecurity.headers().cacheControl();
    }
}
