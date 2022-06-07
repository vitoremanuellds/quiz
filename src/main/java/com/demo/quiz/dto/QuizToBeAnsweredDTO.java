package com.demo.quiz.dto;

import java.util.Set;

import lombok.Data;

@Data
public class QuizToBeAnsweredDTO {
    
    private String title;

    private Set<QuestionToBeAnsweredDTO> questions;

}
