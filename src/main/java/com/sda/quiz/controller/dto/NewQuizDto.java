package com.sda.quiz.controller.dto;

import com.sda.quiz.domain.Quiz;
import com.sda.quiz.domain.QuizCategory;

import java.util.Collections;

public class NewQuizDto {
    private String name;
    private String category;

    public Quiz toQuiz(){
        return new Quiz(name, QuizCategory.valueOf(category.toUpperCase()), Collections.emptyList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NewQuizDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
