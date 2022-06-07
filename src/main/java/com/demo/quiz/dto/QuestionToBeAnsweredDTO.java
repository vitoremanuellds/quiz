package com.demo.quiz.dto;

import java.util.Set;

import lombok.Data;

@Data
public class QuestionToBeAnsweredDTO {
    
    private Long id;

    private String stem;

    private Set<ChoiceDTO> choices;

}
