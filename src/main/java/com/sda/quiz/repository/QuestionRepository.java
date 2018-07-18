package com.sda.quiz.repository;

import com.sda.quiz.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
