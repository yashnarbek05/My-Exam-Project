package com.company.models;

import com.company.db.database;

import java.util.UUID;

public class Capital {
    private final String id;
    private String name;
    private String country_Id;

    public Capital(String name, String country_Id) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.country_Id = country_Id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(String country_Id) {
        this.country_Id = country_Id;
    }



    @Override
    public String toString() {
        return "Capital{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country_Id='" + country_Id + '\'' +
                '}';
    }
}
