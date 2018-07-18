package com.sda.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


//szuka wszystkich metod w tej klasie które mają adnotację requestmapping
@Controller
public class QuizController {
   @GetMapping ("/quiz")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allQuiz");

        return modelAndView;
    }
}
