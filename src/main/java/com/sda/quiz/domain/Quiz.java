package com.sda.quiz.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    //każda encja musi mieć swoje Id
    @Id
    //mówimy jak Id ma być tworzony, jak kolejny, każdy ma unikalny
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated
    private QuizCategory quizCategory;
    @OneToMany
    private List<Question> questions;

    public Quiz() {
    }

    public Quiz(String name, QuizCategory quizCategory, List<Question> questions) {
        this.name = name;
        this.quizCategory = quizCategory;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuizCategory getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(QuizCategory quizCategory) {
        this.quizCategory = quizCategory;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getTotalRating() {
        return questions.stream()
                .mapToInt(e -> e.getRating())
                .sum();
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quizCategory=" + quizCategory +
                ", questions=" + questions +
                '}';
    }
}
