package com.demo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.domain.Question;
import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.NewQuestionDTO;
import com.demo.quiz.exceptions.QuizNotFoundException;
import com.demo.quiz.repositories.QuestionRepository;
import com.demo.quiz.repositories.QuizRepository;
import com.demo.quiz.services.QuizService;
import com.demo.quiz.settings.QuestionMapper;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/quiz")
@Api(value = "Quiz")
public class QuizController {
    
    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionMapper questionMapper;

    @PostMapping
    public ResponseEntity<?> createQuiz(String title) { 
        Long id = this.quizService.createQuiz(title);

        return new ResponseEntity<String>("Quiz vazio com ID: " + id + " criado com sucesso!", HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> addQuestionToQuiz(@PathVariable("id") Long quizId, @RequestBody NewQuestionDTO newQuestionDTO) {
        
        Question question = questionMapper.convertFromNewQuestionDTO(newQuestionDTO);

        try {
            Long questionId = this.quizService.addQuestionToQuiz(quizId, question);
            return new ResponseEntity<String>("Question criada com sucesso! ID: " + questionId, HttpStatus.OK);
        } catch (QuizNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
