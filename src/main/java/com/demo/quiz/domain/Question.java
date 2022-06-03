package com.demo.quiz.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "stem")
    private String stem;


    @Column(name = "number_of_correct_answers")
    private int numberOfCorrectAnswers;

    @Column(name = "allow_selection_of_multiple_choices")
    private boolean allowSelectionOfMultipleChoices;

    @Column(name = "only_rigt_with_complete_answers")
    private boolean onlyRightWithCompleteAnswers;

    @Column(name = "weight_of_question")
    private double weightOfQuestion;

    @ElementCollection
    @CollectionTable(name = "right_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "right_answer")
    private Set<Long> rightAnswers;
    

    @ElementCollection
    @CollectionTable(name = "wrong_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "wrong_answer")
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
