package com.demo.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quiz.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
