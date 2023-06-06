package com.company.models;

import com.company.db.database;

import java.util.UUID;

public class Country {
    private final String id;
    private String name;

    public Country(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
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

    public Capital getCapital(){
        for (Capital capital : database.CAPITALS) {
            if (capital.getCountry_Id().equals(this.id)) {
                return capital;
            }
        }
        return null;
    }
    public static Country getCountryById(String id){
        for (Country country : database.COUNTRIES) {
            if (country.getId().equals(id)) return country;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
