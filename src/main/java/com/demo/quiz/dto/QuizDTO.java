package com.demo.quiz.dto;

import java.util.Set;

import lombok.Data;

@Data
public class QuizDTO {
    
    private String title;

    private Set<Long> questions;

}
