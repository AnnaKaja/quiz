package com.sda.quiz.repository;

import com.sda.quiz.domain.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
