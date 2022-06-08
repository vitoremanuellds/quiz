package com.demo.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quiz.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);

}
