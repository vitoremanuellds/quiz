package com.demo.quiz.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "quizzes")
public class Quiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Column(name = "title")
    private String title;

    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "quiz")
    private Set<Question> questions;

    
    public boolean addQuestion(Question question) {
        return this.questions.add(question);
    }


    public boolean delQuestion(Question question) {
        return this.questions.removeIf(qId -> qId.equals(question));
    }

    public String toString() {
        String r = ""; 

        for (Question q : this.questions) {
            r += q.toString();
        }
        
        return "Title + " + r;
    }

}
