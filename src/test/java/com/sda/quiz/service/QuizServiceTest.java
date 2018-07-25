package com.sda.quiz.service;

import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizCategory;
import com.sda.quiz.domain.QuizNotFoundException;
import com.sda.quiz.repository.QuizRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

public class QuizServiceTest {

    @Test
    public void get_question_successfully() {
        //given
        QuizRepository mock = Mockito.mock(QuizRepository.class);
        Mockito.when(mock.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Quiz("testowy quiz", QuizCategory.GENERAL, new ArrayList<>())));
        QuizService quizService = new QuizService(mock);

        //when
        Quiz quiz = quizService.getQuiz(1L);
        //then
        Assert.assertTrue(quiz.getName().equals("testowy quiz"));
        Assert.assertEquals(QuizCategory.GENERAL, quiz.getQuizCategory());
        Assert.assertEquals(new ArrayList<>(), quiz.getQuestions());
    }

    @Test(expected = QuizNotFoundException.class)
    public void get_quiz_should_throw_not_found_exception() {
        //given
        QuizRepository mock = Mockito.mock(QuizRepository.class);
        Mockito.when(mock.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());
        QuizService quizService = new QuizService(mock);
        //when
        quizService.getQuiz(1L);
        //then
        //exception is throw
    }
}
