package com.sda.quiz.service;

import com.sda.quiz.domain.Question;
import com.sda.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    public QuestionService (QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElseGet(()-> null);

    }
}
