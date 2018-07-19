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

import java.util.*;

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



		List<Question> questions = new ArrayList<Question>();
        questions.add(question);
        questions.add(question2);
        questions.add(question3);

        Collections.shuffle(questions);
	}
//	private void generateRandomN(Question,Quiz){
//		ArrayList arrayList = new ArrayList();
//		Question question = new Question();
//		Random random = new Random();
//		for (int i = 0; i < 36; i++) {


        private void generate(String[] args) {


            int q1 = 1;
            int q2 = 2;
            int q3 = 3;
            int q4 = 4;
            int q5 = 5;
            int q6 = 6;
            int q7 = 7;
            int q8 = 8;
            int[] questions = new int[] { q1, q2, q3, q4,q5,q6,q7,q8};

            System.out.println("Before Shuffle");
            for (int i : questions) {
                System.out.println(i);
            }

            shuffle(questions);

            System.out.println("After Shuffle");
            for (int i : questions) {
                System.out.println(i);
            }
        }

        private static void shuffle(int[] questions) {
            Random random = new Random();

            for (int i = 0; i < questions.length; i++) {
                int newIndex = random.nextInt(questions.length - 1);
                swap(questions, i, newIndex);
            }
        }
            private static void swap(int[] questions, int oldIndex, int newIndex) {
                int temp = questions[oldIndex];
                questions[oldIndex] = questions[newIndex];
                questions[newIndex] = temp;
            }
        }

