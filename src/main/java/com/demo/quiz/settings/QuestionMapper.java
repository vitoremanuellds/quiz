package com.demo.quiz.settings;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.quiz.domain.Question;
import com.demo.quiz.dto.NewQuestionDTO;
import com.demo.quiz.dto.QuestionDTO;
import com.demo.quiz.dto.QuestionToBeAnsweredDTO;

public class QuestionMapper {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private ModelMapper modelMapper;

    public Question convertFromNewQuestionDTO(NewQuestionDTO questionDTO) {
        
        Question question = new Question();

        question.setStem(questionDTO.getStem());
        //question.setAnswers(questionDTO.getAnswers().stream().map(answerMapper::convertFromAnswerDTO).toList());

        return question;

    }


    public NewQuestionDTO convertToNewQuestionDTO(Question question) {
        NewQuestionDTO questionDTO = new NewQuestionDTO();

        questionDTO.setStem(question.getStem());
        //questionDTO.setAnswers(question.getAnswers().stream().map(answerMapper::convertToAnswerDTO).toList());

        return questionDTO;
    }


    public Question convertFromQuestionDTO(QuestionDTO questionDTO) {
        
        Question question = new Question();

        question.setStem(questionDTO.getStem());
        question.setAnswers(questionDTO.getAnswers().stream().map(answerMapper::convertFromAnswerDTO).collect(Collectors.toSet()));

        return question;

    }


    public QuestionDTO convertToQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setStem(question.getStem());
        questionDTO.setAnswers(question.getAnswers().stream().map(answerMapper::convertToAnswerDTO).collect(Collectors.toSet()));

        return questionDTO;
    }


    public QuestionToBeAnsweredDTO convertToQuestionToBeAnswered(Question question) {
        QuestionToBeAnsweredDTO questionToBeAnsweredDTO = new QuestionToBeAnsweredDTO();

        questionToBeAnsweredDTO.setId(question.getId());
        questionToBeAnsweredDTO.setStem(question.getStem());
        questionToBeAnsweredDTO.setChoices(question.getAnswers().stream().map(answerMapper::convertToChoiceDTO).collect(Collectors.toSet()));

        return questionToBeAnsweredDTO;
    }

}
