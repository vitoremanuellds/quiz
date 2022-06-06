package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuizMapperConfig {

    @Bean
    public QuizMapper quizMapper() {
        return new QuizMapper();
    }
}
