package com.demo.quiz.repositories;

import org.springframework.stereotype.Repository;

import com.demo.quiz.domain.Question;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    
    
}
