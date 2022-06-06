package com.demo.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.domain.Answer;
import com.demo.quiz.domain.Question;
import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.AnswerDTO;
import com.demo.quiz.dto.QuestionDTO;
import com.demo.quiz.dto.QuizDTO;
import com.demo.quiz.exceptions.QuestionNotFoundException;
import com.demo.quiz.exceptions.QuizNotFoundException;
import com.demo.quiz.repositories.QuestionRepository;
import com.demo.quiz.repositories.QuizRepository;
import com.demo.quiz.services.QuizService;
import com.demo.quiz.settings.AnswerMapper;
import com.demo.quiz.settings.QuestionMapper;
import com.demo.quiz.settings.QuizMapper;

import io.swagger.annotations.Api;
import io.swagger.models.Response;

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

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping
    public ResponseEntity<?> createQuiz(@RequestBody QuizDTO quizDTO) { 
        Long id = this.quizService.createQuiz(this.quizMapper.convertFromQuizDTO(quizDTO));

        return new ResponseEntity<String>("Quiz vazio com ID: " + id + " criado com sucesso!", HttpStatus.CREATED);
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> addQuestionToQuiz(@PathVariable("id") Long quizId, @RequestBody QuestionDTO questionDTO) {
        
        Question question = questionMapper.convertFromNewQuestionDTO(questionDTO);

        try {
            Long questionId = this.quizService.addQuestionToQuiz(quizId, question);
            return new ResponseEntity<String>("Question criada com sucesso! ID: " + questionId, HttpStatus.OK);
        } catch (QuizNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable("id") Long id) {
        
        try {
            QuizDTO quizDTO = this.quizMapper.convertToQuizDTO(this.quizService.getQuiz(id));
            return new ResponseEntity<QuizDTO>(quizDTO, HttpStatus.OK);
        } catch (QuizNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping(value = "/question/{id}")
    public ResponseEntity<?> addAnswerToQuestion(@PathVariable("id") Long questionId, @RequestBody AnswerDTO answerDTO) {

        Answer answer = this.answerMapper.convertFromAnswerDTO(answerDTO);

        try {
            Long id = this.quizService.addAnswerToQuestion(questionId, answer);
            return new ResponseEntity<String>("Resposta adicionada com sucesso! ID da resposta: " + id, HttpStatus.OK);
        } catch (QuestionNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
