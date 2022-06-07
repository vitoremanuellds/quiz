package com.demo.quiz.settings;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Answer;
import com.demo.quiz.dto.AnswerDTO;
import com.demo.quiz.dto.ChoiceDTO;

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


    public ChoiceDTO convertToChoiceDTO(Answer answer) {
        ChoiceDTO choiceDTO = modelMapper.map(answer, ChoiceDTO.class);

        return choiceDTO;
    }

}
