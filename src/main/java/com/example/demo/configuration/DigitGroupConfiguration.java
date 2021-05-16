package com.example.demo.configuration;

import com.example.demo.entity.DigitGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niu
 * @Description:
 * @date 2021/5/518:51
 */


@Configuration
public class DigitGroupConfiguration {

    @Bean
    public DigitGroup getDigitGroup(){
        return new DigitGroup();
    }
}
