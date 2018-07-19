package com.sda.quiz.controller;

import com.sda.quiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private QuizService quizService;

    public AdminController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/admin/quiz")
    public ModelAndView adminAllQuiz() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/allQuiz");
        modelAndView.addObject("allQuiz", quizService.getAllQuiz());
        return modelAndView;
    }
}
