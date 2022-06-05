package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionMapperConfig {
    
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }


    @Bean
    public QuestionMapper QuestionMapper() {
        return new QuestionMapper();
    }

}
