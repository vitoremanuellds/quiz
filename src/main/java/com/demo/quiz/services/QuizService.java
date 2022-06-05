package com.demo.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.quiz.domain.Question;
import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.NewQuestionDTO;
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
        
        if (this.quizRepository.findById(quizId).isEmpty()) {
            throw new QuizNotFoundException("Quiz não encontrado!");
        }

        Quiz quiz = this.quizRepository.findById(quizId).get();

        this.questionRepository.save(question);

        quiz.addQuestion(question.getId());

        this.quizRepository.save(quiz);

        return question.getId();
    }


    public Long createQuiz(String title) {
        Quiz quiz = new Quiz(title);

        this.quizRepository.save(quiz);

        return quiz.getId();
    }

}
