package com.bookmark.springsecurity.encoder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: hj
 * @DateTime: 2020/9/15 16:55
 * @Description:
 */
//@Component
@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        log.info("rawPassword:{}", rawPassword);
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.info("rawPassword:{},encodedPassword:{}", rawPassword, encodedPassword);
        return encodedPassword.equals(rawPassword.toString());
    }
}
