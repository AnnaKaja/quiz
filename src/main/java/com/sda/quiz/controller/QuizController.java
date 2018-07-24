package com.sda.quiz.controller;

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

    @GetMapping ("/quiz")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allQuiz");

        return modelAndView;
    }
    @GetMapping("/quiz/{id}")
    public ModelAndView getQuiz(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("quiz");
        modelAndView.addObject("quiz", quizService.getQuiz(id));
        return modelAndView;
    }
    @GetMapping("/quiz/{id}/question/{questionId}")
    public ModelAndView getQuestion(@PathVariable("questionId") long id){
        ModelAndView modelAndView = new ModelAndView("quizQuestion");
        modelAndView.addObject("question", questionService.getQuestion(id));
        return  modelAndView;
    }

}
