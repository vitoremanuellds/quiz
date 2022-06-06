package com.demo.quiz.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerMapperConfig {


    @Bean
    public AnswerMapper answerMapper() {
        return new AnswerMapper();
    }
    
}
