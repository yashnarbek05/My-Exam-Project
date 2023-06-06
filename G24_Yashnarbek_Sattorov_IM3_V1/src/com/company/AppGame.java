package com.company;

import com.company.db.database;
import com.company.models.Capital;
import com.company.models.Country;
import com.company.models.User;
import com.company.service.OnlineGameService;

import java.util.Collections;
import java.util.Scanner;

public class AppGame {
    static {
        Country country1 = new Country("Uzbekistan");
        Country country2 = new Country("Russia");
        Country country3 = new Country("UK");
        Country country4 = new Country("USA");
        Country country5 = new Country("Qazagistan");
        Country country6 = new Country("Tajikistan");
        Country country7 = new Country("Japan");
        Country country8 = new Country("France");
        Country country9 = new Country("Germany");
        Country country10 = new Country("China");

        Capital capital1 = new Capital("Tashkent", country1.getId());
        Capital capital2 = new Capital("Moscow",country2.getId());
        Capital capital3 = new Capital("London", country3.getId());
        Capital capital4 = new Capital("Washington", country4.getId());
        Capital capital5 = new Capital("Astana", country5.getId());
        Capital capital6 = new Capital("Dushanbe", country6.getId());
        Capital capital7 = new Capital("Tokyo", country7.getId());
        Capital capital8 = new Capital("Paris", country8.getId());
        Capital capital9 = new Capital("Berlin", country9.getId());
        Capital capital10 = new Capital("Beijing", country10.getId());

        User user = new User("Tony", "tony", "1");

        database.COUNTRIES.add(country1);
        database.COUNTRIES.add(country2);
        database.COUNTRIES.add(country3);
        database.COUNTRIES.add(country4);
        database.COUNTRIES.add(country5);
        database.COUNTRIES.add(country6);
        database.COUNTRIES.add(country7);
        database.COUNTRIES.add(country8);
        database.COUNTRIES.add(country9);
        database.COUNTRIES.add(country10);

        database.CAPITALS.add(capital1);
        database.CAPITALS.add(capital2);
        database.CAPITALS.add(capital3);
        database.CAPITALS.add(capital4);
        database.CAPITALS.add(capital5);
        database.CAPITALS.add(capital6);
        database.CAPITALS.add(capital7);
        database.CAPITALS.add(capital8);
        database.CAPITALS.add(capital9);
        database.CAPITALS.add(capital10);

        database.USER_USER_QUIZ_HISTORY_MAP.put(user, null);
    }
    public static void main(String[] args) {
        OnlineGameService onlineGameService = new OnlineGameService();

        while (true) {
            User user = onlineGameService.cout();
            onlineGameService.menu(user);
        }
    }
}
