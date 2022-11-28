package ru.croc.school.task13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.HashMap;

public class Recommender {

    private Recommender(){}

    public static String recommend(String pathToFilms, String pathToUsers, String viewingHistory) {
        Map<String, String> films = new HashMap<>();
        try (Scanner s = new Scanner(new FileReader(pathToFilms))) {
            while (s.hasNextLine()) {
                String[] pair = s.nextLine().split(",");
                films.put(pair[0], pair[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String[]> users = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader(pathToUsers))) {
            while (s.hasNextLine()) {
                users.add(s.nextLine().split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] filmsInHistory = viewingHistory.split(",");

        //First step

        Set<String> setOfFilmsInHistory = new HashSet<>();
        Collections.addAll(setOfFilmsInHistory, filmsInHistory);

        List<String[]> usersLikeThis = new ArrayList<>();

        for (String[] user : users){
            Set<String> currentUserSet = new HashSet<>();
            Collections.addAll(currentUserSet, user);
            int countOfTheSameFilms = 0;
            for (String film : currentUserSet) {
                if (setOfFilmsInHistory.contains(film)) countOfTheSameFilms++;
            }
            if (setOfFilmsInHistory.size() <= 2 * countOfTheSameFilms) usersLikeThis.add(user);
        }

        //Second step

        Set<String> setOfFilms = films.keySet();
        Set<String> setOfNotWatchedFilms = new HashSet<>();
        for (String film : setOfFilms) {
            if (!setOfFilmsInHistory.contains(film)) setOfNotWatchedFilms.add(film);
        }

        //Third step

        Map<String, Integer> Rating = new HashMap<>();
        int maxCountOfFilm = 0;
        String idOfMaxCountOfFilm = null;
        for (String[] user : usersLikeThis) {
            for (String film : user) {
                if (setOfNotWatchedFilms.contains(film)) {
                    Integer countOfCurrentFilm = Rating.get(film);
                    if (countOfCurrentFilm == null) countOfCurrentFilm = 0;
                    countOfCurrentFilm++;
                    Rating.put(film, countOfCurrentFilm);
                    if (countOfCurrentFilm > maxCountOfFilm) {
                        maxCountOfFilm = countOfCurrentFilm;
                        idOfMaxCountOfFilm = film;
                    }
                }
            }
        }
        return films.get(idOfMaxCountOfFilm);
    }
}
