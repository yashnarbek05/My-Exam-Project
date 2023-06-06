package com.company.models;

import java.util.List;
import java.util.UUID;

public class Quiz {
    private final String id;
    private String country_Id;
    private List<Answer> answers;

    public Quiz(String country_Id, List<Answer> answers) {
        this.id = UUID.randomUUID().toString();
        this.country_Id = country_Id;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public String getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(String country_Id) {
        this.country_Id = country_Id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void sout() {
        System.out.println(Country.getCountryById(this.country_Id).getName());
        for (Answer answer : answers) {
            System.out.println(answer);
        }
    }
}
