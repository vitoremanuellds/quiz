package com.demo.quiz.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.demo.quiz.domain.Answer;

import lombok.Data;

@Data
public class QuestionDTO {
    
    private String stem;

    private Set<AnswerDTO> answers;

}
