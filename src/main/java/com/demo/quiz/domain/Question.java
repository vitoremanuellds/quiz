package com.demo.quiz.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {
    
    private Long id;

    private String stem;

    private int numberOfCorrectAnswers;

    private boolean allowSelectionOfMultipleChoices;

    private boolean onlyRightWithCompleteAnswers;

    private double weightOfQuestion;

    private Set<Long> rightAnswers;

    private Set<Long> wrongAnswers;

    public Question(String stem, int numberOfCorrectAnswers, boolean allowSelectionOfMultipleChoices, boolean onlyRightWithCompleteAnswers, double weightOfQuestion) {

        this.stem = stem;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.allowSelectionOfMultipleChoices = allowSelectionOfMultipleChoices;
        this.onlyRightWithCompleteAnswers = onlyRightWithCompleteAnswers;
        this.weightOfQuestion = weightOfQuestion;

        this.rightAnswers = new HashSet<Long>();
        this.wrongAnswers = new HashSet<Long>();

    }


    public boolean addRightAnswer(Long answerId) {
        return this.rightAnswers.add(answerId);
    }


    public boolean addWrongAnswer(Long answerId) {
        return this.wrongAnswers.add(answerId);
    }


    public boolean delRightAnswer(Long answerId) {
        return this.rightAnswers.removeIf(aId -> aId.equals(answerId));
    }


    public boolean delWrongAnswer(Long answerId) {
        return this.wrongAnswers.removeIf(aId -> aId.equals(answerId));
    }


    

}
