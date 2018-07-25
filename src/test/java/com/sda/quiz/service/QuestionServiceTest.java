package com.sda.quiz.service;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.QuestionCategory;
import com.sda.quiz.domain.QuestionNotFoundException;
import com.sda.quiz.repository.QuestionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

public class QuestionServiceTest {


    @Test
    public void get_quiz_successfully() {
        //given
        QuizService quizService = Mockito.mock(QuizService.class);
        QuestionRepository questionRepositoryMock = Mockito.mock(QuestionRepository.class);
        Mockito.when(questionRepositoryMock.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Question("testowy question", new ArrayList<>(), QuestionCategory.BIOLOGY, 10)));
        QuestionService questionService = new QuestionService(questionRepositoryMock, quizService);

        //when
        Question question = questionService.getQuestion(1L);

        //then
        Assert.assertTrue(question.getQuestionContent().equals("testowy question"));
        Assert.assertEquals(new ArrayList<>(), question.getAnswers());
        Assert.assertEquals(QuestionCategory.BIOLOGY, question.getQuestionCategory());
        Assert.assertEquals(10, question.getRating());
    }

    @Test(expected = QuestionNotFoundException.class)
    public void get_question_should_throw_not_found_exception() {

        //given
        QuizService quizService = Mockito.mock(QuizService.class);
        QuestionRepository questionRepositoryMock = Mockito.mock(QuestionRepository.class);
        Mockito.when(questionRepositoryMock.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());
        QuestionService questionService = new QuestionService(questionRepositoryMock, quizService);

        //when
        questionService.getQuestion(1L);
        //then
        //exception is throw
    }
}
