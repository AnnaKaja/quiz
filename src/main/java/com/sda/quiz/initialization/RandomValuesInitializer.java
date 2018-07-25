package com.sda.quiz.initialization;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.QuestionCategory;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizCategory;
import com.sda.quiz.repository.QuestionRepository;
import com.sda.quiz.repository.QuizRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RandomValuesInitializer implements CommandLineRunner {
    private Random random;
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;

    public RandomValuesInitializer(Random random, QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.random = random;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 4; i++) {
            saveNewQuiz(quizRepository, questionRepository);
        }

    }

    private void saveNewQuiz(QuizRepository quizRepository, QuestionRepository questionRepository) {
        Question q1 = questionRepository.save(createRandomQuestion());
        Question q2 = questionRepository.save(createRandomQuestion());
        Question q3 = questionRepository.save(createRandomQuestion());
        Question q4 = questionRepository.save(createRandomQuestion());

        quizRepository.save(createRandomQuiz(Arrays.asList(q1, q2, q3, q4)));
    }

    private Question createRandomQuestion() {
        Question question = new Question();
        question.setQuestionContent(RandomStringUtils.randomAlphabetic(20));
        question.setAnswers(Arrays.asList(RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10))
        );
        question.setQuestionCategory(QuestionCategory.BIOLOGY);
        question.setRating(random.nextInt(10) + 1);

        return question;
    }

    private Quiz createRandomQuiz(List<Question> questions) {
        Quiz quiz = new Quiz();
        quiz.setName(RandomStringUtils.randomAlphabetic(20));
        quiz.setQuizCategory(QuizCategory.GENERAL);
        quiz.setQuestions(questions);

        return quiz;
    }
}
