package com.demo.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quiz.domain.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    
}
