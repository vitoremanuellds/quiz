package com.demo.quiz.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quiz {
    
    private Long id;
    
    private String title;

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
