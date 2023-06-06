package com.company.models;

import java.util.Objects;
import java.util.UUID;

public class Answer {
    private final String id;
    private String capital_Id;
    private boolean isCorrect;

    public Answer(String capital_Id, boolean isCorrect) {
        this.id = UUID.randomUUID().toString();
        this.capital_Id = capital_Id;
        this.isCorrect = true;
    }

    public String getId() {
        return id;
    }

    public String getCapital_Id() {
        return capital_Id;
    }

    public void setCapital_Id(String capital_Id) {
        this.capital_Id = capital_Id;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", capital_Id='" + capital_Id + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
