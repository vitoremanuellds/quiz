package com.demo.quiz.dto;

import java.util.Set;

import lombok.Data;


@Data
public class NewQuestionDTO {
    
    private String stem;

    private int numberOfCorrectAnswers;

    private boolean allowSelectionOfMultipleChoices;

    private boolean onlyRightWithCompleteAnswers;

    private double weightOfQuestion;

    private Set<String> rightAnswers;

    private Set<String> wrongAnswers;

}
