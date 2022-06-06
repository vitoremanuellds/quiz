package com.demo.quiz.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "choices")
    private List<Answer> choices;

    public Question(String stem, int numberOfCorrectAnswers, boolean allowSelectionOfMultipleChoices, boolean onlyRightWithCompleteAnswers, double weightOfQuestion) {

        this.stem = stem;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.allowSelectionOfMultipleChoices = allowSelectionOfMultipleChoices;
        this.onlyRightWithCompleteAnswers = onlyRightWithCompleteAnswers;
        this.weightOfQuestion = weightOfQuestion;

        this.choices = new ArrayList<Answer>();

    }


    public boolean addAnswer(Answer answer) {
        return this.choices.add(answer);
    }


    public boolean delAnswer(Answer answer) {
        return this.choices.remove(answer);
    }
    

}
