package com.sda.quiz;

import com.sda.quiz.domain.Question;
import com.sda.quiz.domain.QuestionCategory;
import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizCategory;
import com.sda.quiz.repository.QuestionRepository;
import com.sda.quiz.repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(QuizRepository quizRepository, QuestionRepository questionRepository){
		return (args -> {
			saveNewQuiz(quizRepository, questionRepository);
			saveNewQuiz(quizRepository, questionRepository);
			saveNewQuiz(quizRepository, questionRepository);
			saveNewQuiz(quizRepository, questionRepository);
		});
	}

	private void saveNewQuiz(QuizRepository quizRepository, QuestionRepository questionRepository) {
		Question question = new Question("abcd", Arrays.asList("a", "b", "c", "d"), QuestionCategory.BIOLOGY, 5);
		Question question2 = new Question("abcd2", Arrays.asList("a", "b", "c", "d"), QuestionCategory.BIOLOGY, 5);
		Question question3 = new Question("abcd3", Arrays.asList("a", "b", "c", "d"), QuestionCategory.BIOLOGY, 5);
		Question question4 = new Question("abcd4", Arrays.asList("a", "b", "c", "d"), QuestionCategory.BIOLOGY, 5);
		Question savedQuestion =  questionRepository.save(question);
		Question savedQuestion2 =  questionRepository.save(question2);
		Question savedQuestion3 =  questionRepository.save(question3);
		Question savedQuestion4 =  questionRepository.save(question4);

		Quiz quiz = new Quiz("test", QuizCategory.GENERAL, Arrays.asList(savedQuestion, savedQuestion2, savedQuestion3, savedQuestion4));
		quizRepository.save(quiz);
	}
}
