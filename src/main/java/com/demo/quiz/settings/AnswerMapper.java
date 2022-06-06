package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Answer;
import com.demo.quiz.dto.AnswerDTO;

public class AnswerMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public AnswerDTO convertToAnswerDTO(Answer answer) {
        AnswerDTO answerDTO = modelMapper.map(answer, AnswerDTO.class);

        return answerDTO;
    }


    public Answer convertFromAnswerDTO(AnswerDTO answerDTO) {
        Answer answer = modelMapper.map(answerDTO, Answer.class);

        return answer;
    }

}
