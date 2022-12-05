package ru.croc.school.task13;

import java.util.*;

public class Recommender {

    private Recommender(){}

    public static String recommend(String pathToFilms, String pathToUsers) {
        Map<Integer, Film> allFilms = MyReader.readFilms(pathToFilms);
        List<User> users = MyReader.readUsers(pathToUsers, allFilms);
        User recommendedUser = MyReader.readRecommendedUser(allFilms);


        //First step

        List<User> usersLikeThis = new ArrayList<>();

        for (User user : users){
            if (recommendedUser.ifAtLeastHalf(user))
                usersLikeThis.add(user);
        }


        //Second step

        Set<Film> setOfNotWatchedFilms = recommendedUser.notWatchedFilms(allFilms);


        //Third step

        Map<Film, Integer> Rating = new HashMap<>();
        int maxCountOfFilm = 0;
        Film filmWithMaxCount = null;
        for (User user : usersLikeThis) {
            for (Film film : user.getHistoryOfFilms()) {
                if (setOfNotWatchedFilms.contains(film)) {
                    Integer countOfCurrentFilm = Rating.get(film);
                    if (countOfCurrentFilm == null) countOfCurrentFilm = 0;
                    countOfCurrentFilm++;
                    Rating.put(film, countOfCurrentFilm);
                    if (countOfCurrentFilm > maxCountOfFilm) {
                        maxCountOfFilm = countOfCurrentFilm;
                        filmWithMaxCount = film;
                    }
                }
            }
        }
        return filmWithMaxCount.toString();
    }
}
