package com.demo.quiz.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperConfig {
    
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

}
