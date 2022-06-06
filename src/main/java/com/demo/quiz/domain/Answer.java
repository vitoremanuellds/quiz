package com.demo.quiz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Answers")
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "correct_answer")
    private boolean correctAnswer;

    @Column(name = "content")
    private String content;


    public Answer(String content, boolean correctAnswer) {
        this.content = content;
        this.correctAnswer = correctAnswer;
    }

}
