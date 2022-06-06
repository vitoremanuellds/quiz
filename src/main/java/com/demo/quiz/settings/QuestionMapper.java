package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Question;
import com.demo.quiz.dto.QuestionDTO;

public class QuestionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Question convertFromNewQuestionDTO(QuestionDTO questionDTO) {
        
        Question question = modelMapper.map(questionDTO, Question.class);

        return question;

    }

    public QuestionDTO convertToNewQuestionDTO(Question question) {
        QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);

        return questionDTO;
    }

}
