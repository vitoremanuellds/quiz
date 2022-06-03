package com.demo.quiz.domain;

public class Answer {
    
    private Long id;

    private Long questionId;

    private String content;

    public Answer(Long questionId, String content) {
        this.questionId = questionId;
        this.content = content;
    }

}
