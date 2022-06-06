package com.demo.quiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.quiz.domain.Answer;
import com.demo.quiz.domain.Question;
import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.QuestionDTO;
import com.demo.quiz.dto.QuizDTO;
import com.demo.quiz.dto.AnswerDTO;
import com.demo.quiz.dto.NewQuestionDTO;
import com.demo.quiz.dto.NewQuizDTO;
import com.demo.quiz.exceptions.QuestionNotFoundException;
import com.demo.quiz.exceptions.QuizNotFoundException;
import com.demo.quiz.repositories.AnswerRepository;
import com.demo.quiz.repositories.QuestionRepository;
import com.demo.quiz.repositories.QuizRepository;
import com.demo.quiz.settings.AnswerMapper;
import com.demo.quiz.settings.QuestionMapper;
import com.demo.quiz.settings.QuizMapper;

@Service
public class QuizService {
    
    
    @Autowired
    private QuizRepository quizRepository;


    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private AnswerRepository answerRepository;


    @Autowired
    private QuestionMapper questionMapper;


    @Autowired
    private QuizMapper quizMapper;


    @Autowired
    private AnswerMapper answerMapper;


    public Long addQuestionToQuiz(Long quizId, NewQuestionDTO questionDTO) throws QuizNotFoundException {
        Optional<Quiz> quiz = this.quizRepository.findById(quizId);

        if (quiz.isEmpty()) {
            throw new QuizNotFoundException("Quiz não encontrado!");
        }

        Question question = this.questionMapper.convertFromNewQuestionDTO(questionDTO);

        question.setQuiz(quiz.get());

        this.questionRepository.save(question);

        return question.getId();
    }


    public Long createQuiz(NewQuizDTO quizDTO) {
        Quiz quiz = this.quizMapper.convertFromNewQuizDTO(quizDTO);

        this.quizRepository.save(quiz);

        return quiz.getId();
    }


    public QuizDTO getQuiz(Long quizId) throws QuizNotFoundException {
        Optional<Quiz> quiz = this.quizRepository.findById(quizId);

        if (quiz.isEmpty()) {
            throw new QuizNotFoundException("Quiz não encontrado!");
        }

        return this.quizMapper.convertToQuizDTO(quiz.get());
    }


    public Long addAnswerToQuestion(Long questionId, AnswerDTO answerDTO) throws QuestionNotFoundException {

        Optional<Question> question = this.questionRepository.findById(questionId);

        if (question.isEmpty()) {
            throw new QuestionNotFoundException("Question não encontrada!");
        }

        Answer answer = this.answerMapper.convertFromAnswerDTO(answerDTO);
        answer.setQuestion(question.get());

        this.answerRepository.save(answer);

        return answer.getId();
    }

}
