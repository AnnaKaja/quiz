package com.sda.quiz.service;

import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizNotFoundException;
import com.sda.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAllQuiz() {
        Iterable<Quiz> iterable = quizRepository.findAll();
        List<Quiz> list = new ArrayList<>();
        iterable.forEach(e -> list.add(e));
        return list;

    }

    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id).orElseGet(() -> {
            throw new QuizNotFoundException("Quiz not found");
        });
    }

    public Quiz fetchNextQuiz(Quiz quiz) {
        List<Quiz> allQuiz = getAllQuiz();
        int index = allQuiz.indexOf(quiz);
        return index + 1 < allQuiz.size() ? allQuiz.get(index + 1) : null;
    }
}
