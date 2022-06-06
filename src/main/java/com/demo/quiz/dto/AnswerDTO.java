package com.demo.quiz.dto;

import com.demo.quiz.domain.Question;

import lombok.Data;

@Data
public class AnswerDTO {

    private String content;

    private boolean correctAnswer;

}
