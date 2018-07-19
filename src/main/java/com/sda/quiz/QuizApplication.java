package com.sda.quiz;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.QuestionCategory;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizCategory;
import com.sda.quiz.repository.QuestionRepository;
import com.sda.quiz.repository.QuizRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class QuizApplication {

    @Autowired
    private Random random;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(QuizRepository quizRepository, QuestionRepository questionRepository) {
        return (args -> {
            for (int i = 0; i < 4; i++) {
                saveNewQuiz(quizRepository, questionRepository);
            }
        });
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

