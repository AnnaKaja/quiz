package com.sda.quiz.controller;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.service.QuestionService;
import com.sda.quiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


//szuka wszystkich metod w tej klasie które mają adnotację requestmapping
@Controller
public class QuizController {
    private QuizService quizService;
    private QuestionService questionService;

    public QuizController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping("/quiz")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allQuiz");
        return modelAndView;
    }

    @GetMapping("/quiz/{id}")
    public ModelAndView getQuiz(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("quiz");
        Quiz quiz = quizService.getQuiz(id);
        modelAndView.addObject("quiz", quiz);
        modelAndView.addObject("nextQuizPath", fetchNextQuizPath(quizService.fetchNextQuiz(quiz)));
        return modelAndView;
    }

    @GetMapping("/quiz/{quizId}/question/{questionId}")
    public ModelAndView getQuestion(@PathVariable("questionId") long questionId, @PathVariable("quizId") long quizId) {
        ModelAndView modelAndView = new ModelAndView("quizQuestion");
        modelAndView.addObject("question", questionService.getQuestion(questionId));
        modelAndView.addObject("nextQuestionPath", fetchNextQuestionPath(questionService.fetchNextQuestion(quizId, questionId), quizId));
        return modelAndView;
    }

    private String fetchNextQuestionPath(Question question, long quizId) {
        return question == null ? null : "/quiz/" + quizId + "/question/" + question.getId();
    }

    private String fetchNextQuizPath(Quiz quiz) {
        return quiz != null ? "/quiz/" + quiz.getId() : null;
    }
}
