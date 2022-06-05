package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Question;
import com.demo.quiz.dto.NewQuestionDTO;
import com.demo.quiz.dto.QuestionDTO;

public class QuestionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Question convertFromNewQuestionDTO(NewQuestionDTO newQuestionDTO) {
        
        Question question = modelMapper.map(newQuestionDTO, Question.class);

        return question;

    }

    public NewQuestionDTO convertToNewQuestionDTO(Question question) {
        NewQuestionDTO newQuestionDTO = modelMapper.map(question, NewQuestionDTO.class);

        return newQuestionDTO;
    }

}
