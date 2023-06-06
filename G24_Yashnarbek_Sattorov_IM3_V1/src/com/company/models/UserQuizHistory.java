package com.company.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserQuizHistory {
    private final String id;
    private String user_Id;
    private LocalDateTime date;
    private List<Quiz> quizzes;
    private Integer totalCorrectAnswers;

    public UserQuizHistory(String user_Id, LocalDateTime date,
                           List<Quiz> quizzes, Integer totalCorrectAnswers) {
        this.id = UUID.randomUUID().toString();
        this.user_Id = user_Id;
        this.date = date;
        this.quizzes = quizzes;
        this.totalCorrectAnswers = totalCorrectAnswers;
    }

    public String getId() {
        return id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Integer getTotalCorrectAnswers() {
        return totalCorrectAnswers;
    }

    public void setTotalCorrectAnswers(Integer totalCorrectAnswers) {
        this.totalCorrectAnswers = totalCorrectAnswers;
    }

    @Override
    public String toString() {
        return "UserQuizHistory{" +
                "id='" + id + '\'' +
                ", user_Id='" + user_Id + '\'' +
                ", date=" + date +
                ", quizzes=" + quizzes +
                ", totalCorrectAnswers=" + totalCorrectAnswers +
                '}';
    }
}
