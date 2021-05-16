package com.example.demo.configuration;

import com.example.demo.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niu
 * @Description:
 * @date 2021/5/1620:04
 */


@Configuration
public class JwtUtilConfiguration {

    @Bean
    public JwtUtils jwtUtils() {
        JwtUtils jwt = new JwtUtils();
        jwt.setFailureTime((long)360000);
        jwt.setKey("userLogin");
        return jwt;
    }
}
