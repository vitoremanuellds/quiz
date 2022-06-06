package com.demo.quiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.quiz.domain.Question;
import com.demo.quiz.domain.Quiz;
import com.demo.quiz.exceptions.QuizNotFoundException;
import com.demo.quiz.repositories.QuestionRepository;
import com.demo.quiz.repositories.QuizRepository;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public Long addQuestionToQuiz(Long quizId, Question question) throws QuizNotFoundException {
        
        Optional<Quiz> quizOp = this.quizRepository.findById(quizId);

        if (quizOp.isEmpty()) {
            throw new QuizNotFoundException("Quiz não encontrado!");
        }

        Quiz quiz = quizOp.get();

        this.questionRepository.save(question);

        quiz.addQuestion(question);

        this.quizRepository.save(quiz);

        return question.getId();
    }


    public Long createQuiz(Quiz quiz) {

        this.quizRepository.save(quiz);

        return quiz.getId();
    }

    public Quiz getQuiz(Long quizId) throws QuizNotFoundException {
        Optional<Quiz> quiz = this.quizRepository.findById(quizId);

        if (quiz.isEmpty()) {
            throw new QuizNotFoundException("Quiz não encontrado!");
        }

        return quiz.get();
    }

}
