package com.demo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.dto.AnswerDTO;
import com.demo.quiz.dto.NewQuestionDTO;
import com.demo.quiz.dto.QuizDTO;
import com.demo.quiz.dto.QuizToBeAnsweredDTO;
import com.demo.quiz.dto.NewQuizDTO;
import com.demo.quiz.dto.QuestionDTO;
import com.demo.quiz.exceptions.QuestionNotFoundException;
import com.demo.quiz.exceptions.QuizNotFoundException;
import com.demo.quiz.services.QuizService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.HttpMethod;

import org.springframework.web.bind.annotation.GetMapping;
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


    @PostMapping
    @ApiOperation(value = "Cria um novo Quiz.")
    public ResponseEntity<?> createQuiz(@RequestBody NewQuizDTO newQuizDTO) {

        Long id = this.quizService.createQuiz(newQuizDTO);

        return new ResponseEntity<String>("Quiz vazio com ID: " + id + " criado com sucesso!", HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{id}")
    @ApiOperation(value = "Adiciona uma Question a um Quiz através do ID do Quiz.")
    public ResponseEntity<?> addQuestionToQuiz(@PathVariable("id") Long quizId, @RequestBody NewQuestionDTO questionDTO) {

        try {

            Long questionId = this.quizService.addQuestionToQuiz(quizId, questionDTO);
            return new ResponseEntity<String>("Question criada com sucesso! ID: " + questionId, HttpStatus.OK);

        } catch (QuizNotFoundException e) {

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Recupera um Quiz através do seu ID.")
    public ResponseEntity<?> getQuiz(@PathVariable("id") Long id, @RequestParam(name = "toBeAnswered", defaultValue = "false") String toBeAnswered) {
        
        try {
            if (toBeAnswered.equals("false")) {
                return new ResponseEntity<QuizDTO>(this.quizService.getQuiz(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<QuizToBeAnsweredDTO>(this.quizService.getQuizToBeAnswered(id), HttpStatus.OK);
            }
        
        } catch (QuizNotFoundException e) {
        
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        
        }

    }

    
    @PatchMapping(value = "/question/{id}")
    @ApiOperation(value = "Adiciona uma Answer a uma Question através do ID da Question.")
    public ResponseEntity<?> addAnswerToQuestion(@PathVariable("id") Long questionId, @RequestBody AnswerDTO answerDTO) {

        try {
            Long id = this.quizService.addAnswerToQuestion(questionId, answerDTO);
            return new ResponseEntity<String>("Resposta adicionada com sucesso! ID da resposta: " + id, HttpStatus.OK);
        } catch (QuestionNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping(value = "/question/{id}")
    @ApiOperation(value = "Recupera uma Question através do seu ID.")
    public ResponseEntity<?> getQuestion(@PathVariable("id") Long id) {

        try {
            return new ResponseEntity<QuestionDTO>(this.quizService.getQuestion(id), HttpStatus.OK);
        } catch (QuestionNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
