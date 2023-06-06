package com.company.service;

import com.company.db.database;
import com.company.models.*;

import java.time.LocalDateTime;
import java.util.*;

public class OnlineGameService {

    public static User cout() {
        System.out.print("""
                1) registration
                2) login
                0) exit
                
                :? 
                """);
        String option = new Scanner(System.in).nextLine();

         if(option.equals("0")) System.exit(0);
         if(option.equals("2")) return OnlineGameService.login();
         if(option.equals("1")) return OnlineGameService.registration();
         return null;
    }

    private static User login() {
        System.out.print("Enter userName: ");
        String userName = new Scanner(System.in).nextLine();

        System.out.print("Enter password: ");
        String password = new Scanner(System.in).nextLine();

        if(userName.isBlank() || userName.isEmpty()) {
            System.out.println("userName is empty!");
            return null;
        }

        if(password.isBlank() || password.isEmpty()) {
            System.out.println("password is empty!");
            return null;
        }

        for (User user : database.USER_USER_QUIZ_HISTORY_MAP.keySet()) {
            if(user.getUserName().equals(userName)
                    && user.getPassword().equals(password)) return user;
        }
        return null;
    }

    private static User registration() {
        System.out.print("Enter firstName: ");
        String firstName = new Scanner(System.in).nextLine();
        System.out.print("Enter userName: ");
        String userName = new Scanner(System.in).nextLine();

        System.out.print("Enter password: ");
        String password = new Scanner(System.in).nextLine();


        if(firstName.isBlank() || firstName.isEmpty()) {
            System.out.println("firstName is empty!");
            return null;
        }

        if(userName.isBlank() || userName.isEmpty()) {
            System.out.println("userName is empty!");
            return null;
        }

        if(password.isBlank() || password.isEmpty()) {
            System.out.println("password is empty!");
            return null;
        }

        User user = new User(firstName, userName.toLowerCase(), password);
        database.USER_USER_QUIZ_HISTORY_MAP.put(user, null);
        return user;
    }

    public static void game(User user) {
        UserQuizHistory userQuizHistory =
                new UserQuizHistory(user.getId(), LocalDateTime.now(), new ArrayList<>(), 0);
        System.out.println("Country     ->      Capital");
        for (int i = 0; i < 5; i++) {

            Quiz quiz = OnlineGameService.generateQuiz();
            quiz.sout();
            System.out.println("?: ");
            String answer = new Scanner(System.in).nextLine();
            List<Quiz> quizzes = userQuizHistory.getQuizzes();
            quizzes.add(quiz);
            userQuizHistory.setQuizzes(quizzes);
            if (answer.equals(Objects.requireNonNull
                    (Country.getCountryById(quiz.getCountry_Id())).getCapital().getName())){
                userQuizHistory.setTotalCorrectAnswers(userQuizHistory.getTotalCorrectAnswers()+1);
            }

        }
        database.USER_USER_QUIZ_HISTORY_MAP.put(user, userQuizHistory);
    }

    private static Quiz generateQuiz() {
        int index = new Random().nextInt(0, database.COUNTRIES.size());
        Country country = database.COUNTRIES.get(index);

        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(country.getCapital().getCountry_Id(), true));
        while (answers.size() < 4){
            Capital capital = database.CAPITALS.get(new Random()
                    .nextInt(0, database.CAPITALS.size()));
            if (!capital.getName().equals(country.getCapital().getName()))
                answers.add(new Answer(capital.getCountry_Id(), false));
        }

        Quiz quiz = new Quiz(country.getId(), answers);
        return quiz;
    }

    public void menu(User user) {
        System.out.print("""
                1) Start Quiz
                2) Show my quiz history
                3) logout
                
                :?
                """);
        String option = new Scanner(System.in).nextLine();

        if (option.equals("1")) OnlineGameService.game(user);
        if (option.equals("2")) OnlineGameService.showQuizHistory(user);
        if (option.equals("3")) OnlineGameService.cout();
        else {
            System.out.println("Enter correct number!");
            menu(user);
        }
    }

    private static void showQuizHistory(User user) {
        UserQuizHistory history = database.USER_USER_QUIZ_HISTORY_MAP.get(user);
        System.out.println(""+ history.getDate() + history.getTotalCorrectAnswers() + "/5");
    }
}
