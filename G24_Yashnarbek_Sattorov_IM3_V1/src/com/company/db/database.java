package com.company.db;

import com.company.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface database {
    List<Country> COUNTRIES = new ArrayList<>();
    List<Capital> CAPITALS = new ArrayList<>();
    Map<Quiz, Answer> QUIZ_ANSWER_MAP = new HashMap<>();
    Map<User, UserQuizHistory> USER_USER_QUIZ_HISTORY_MAP = new HashMap<>();
}
