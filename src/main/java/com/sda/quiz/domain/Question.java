package com.sda.quiz.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String questionContent;
    @ElementCollection
    @CollectionTable(name = "Answers")
    private List<String> answers;
    @Enumerated
    private QuestionCategory questionCategory;
    private int rating;

    public Question() {
    }

    public Question(String questionContent, List<String> answers, QuestionCategory questionCategory, int rating) {
        this.questionContent = questionContent;
        this.answers = answers;
        this.questionCategory = questionCategory;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategory questionCategory) {
        this.questionCategory = questionCategory;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
