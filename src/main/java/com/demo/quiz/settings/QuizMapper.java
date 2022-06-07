package com.demo.quiz.settings;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.NewQuizDTO;
import com.demo.quiz.dto.QuizDTO;
import com.demo.quiz.dto.QuizToBeAnsweredDTO;

public class QuizMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionMapper questionMapper;


    public Quiz convertFromNewQuizDTO(NewQuizDTO quizDTO) {
        Quiz quiz = new Quiz();

        quiz.setTitle(quizDTO.getTitle());

        return quiz;
    }


    public NewQuizDTO convertToNewQuizDTO(Quiz quiz) {
        NewQuizDTO quizDTO = new NewQuizDTO();

        quizDTO.setTitle(quiz.getTitle());

        return quizDTO;
    }


    public QuizDTO convertToQuizDTO(Quiz quiz) {
        QuizDTO quizDTO = new QuizDTO();

        quizDTO.setTitle(quiz.getTitle());
        quizDTO.setQuestions(quiz.getQuestions().stream().map(questionMapper::convertToQuestionDTO).collect(Collectors.toSet()));

        return quizDTO;
    }


    public Quiz convertFromQuizDTO(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();

        quiz.setTitle(quizDTO.getTitle());
        quiz.setQuestions(quizDTO.getQuestions().stream().map(questionMapper::convertFromQuestionDTO).collect(Collectors.toSet()));

        return quiz;
    }


    public QuizToBeAnsweredDTO convertToQuizToBeAnsweredDTO(Quiz quiz) {
        QuizToBeAnsweredDTO quizToBeAnsweredDTO = new QuizToBeAnsweredDTO();

        quizToBeAnsweredDTO.setTitle(quiz.getTitle());
        quizToBeAnsweredDTO.setQuestions(quiz.getQuestions().stream().map(questionMapper::convertToQuestionToBeAnswered).collect(Collectors.toSet()));

        return quizToBeAnsweredDTO;
    }

}
