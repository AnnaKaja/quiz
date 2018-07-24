package com.sda.quiz.service;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private QuizService quizService;

    public QuestionService(QuestionRepository questionRepository, QuizService quizService) {
        this.questionRepository = questionRepository;
        this.quizService = quizService;
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseGet(() -> null);

    }

    public Question fetchNextQuestion(long quizId, long questionId) {
        Quiz quiz = quizService.getQuiz(quizId);
        List<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (i < questions.size() - 1 && questions.get(i).getId() == questionId) {
                return questions.get(i + 1);
            }
        }
        return null;
    }
}
