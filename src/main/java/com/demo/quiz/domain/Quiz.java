package com.demo.quiz.domain;

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
@Table(name = "quizzes")
public class Quiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name = "questions", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(name = "question")
    private Set<Long> questions;


    public Quiz(String title) {
        this.title = title;
        this.questions = new HashSet<>();
    }

    
    public boolean addQuestion(Long questionId) {
        return this.questions.add(questionId);
    }


    public boolean delQuestion(Long questionId) {
        return this.questions.removeIf(qId -> qId.equals(questionId));
    }

}
