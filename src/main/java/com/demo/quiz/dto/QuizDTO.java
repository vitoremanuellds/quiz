package com.demo.quiz.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.demo.quiz.domain.Question;

import lombok.Data;

@Data
public class QuizDTO {
    
    private String title;

    private List<Question> questions;

}
