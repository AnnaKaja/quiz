package com.sda.quiz.controller;

import com.sda.quiz.controller.dto.NewQuizDto;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.service.QuizService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/admin/quiz/{quizId}")
    public ModelAndView adminQuizById(@PathVariable("quizId") long quizId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("quiz", quizService.getQuizById(quizId));
        modelAndView.setViewName("admin/quiz");
        return modelAndView;
    }

    @GetMapping("/admin/quiz-new")
    public ModelAndView newQuiz() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/newQuiz");
        return modelAndView;
    }

    @PostMapping("/admin/quiz")
    public String quizCreation(@ModelAttribute NewQuizDto quiz) {
        Quiz newCreatedQuiz = quizService.saveQuiz(quiz.toQuiz());
        return "redirect:/admin/quiz/" + newCreatedQuiz.getId();
    }

    @GetMapping("/admin/quiz/{quizId}/question/{questionId}")
    public ModelAndView getAdminQuizQuestion(@PathVariable("quizId") long quizId, @PathVariable("questionId") long questionId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("quiz", quizService.getQuizById(quizId));
        return modelAndView;
    }
}
