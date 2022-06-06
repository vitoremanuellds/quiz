package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Quiz;
import com.demo.quiz.dto.QuizDTO;

public class QuizMapper {
    
    @Autowired
    private ModelMapper modelMapper;


    public Quiz convertFromQuizDTO(QuizDTO quizDTO) {
        Quiz quiz = modelMapper.map(quizDTO, Quiz.class);

        return quiz;
    }


    public QuizDTO convertToQuizDTO(Quiz quiz) {
        QuizDTO quizDTO = modelMapper.map(quiz, QuizDTO.class);

        return quizDTO;
    }
    

}
