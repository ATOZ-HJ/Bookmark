package com.bookmark.springsecurity.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: hj
 * @DateTime: 2020/9/15 16:29
 * @Description: 自定义用户登录接口
 */
@Component
@Slf4j
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 校验，根据用户名定位用户
     * @param username 标识需要其数据的用户的用户名。
     * @return 核心用户信息，一个完全填充的用户记录
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123");
        log.info("登录名称 username :{}", username);
        log.info("密码:{}",password);
        return new User(username, password, AuthorityUtils.createAuthorityList("admin"));
    }
}
