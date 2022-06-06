package com.demo.quiz.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {
    
    private String stem;

    private int numberOfCorrectAnswers;

    private boolean allowSelectionOfMultipleChoices;

    private boolean onlyRightWithCompleteAnswers;

    private double weightOfQuestion;

    private String rightAnswer;

    private List<String> wrongAnswers;

}
