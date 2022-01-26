package com.example.demo.configuration;

import com.example.demo.entity.DigitGroup;
import com.example.demo.entity.GameRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author niu
 * @Description:
 * @date 2021/5/619:43
 */

@Configuration
public class GameRecordConfiguration {
    
    @Bean
    public GameRecord getGameRecord(){
        return new GameRecord();
    }
}
