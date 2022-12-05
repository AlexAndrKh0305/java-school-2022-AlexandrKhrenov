package ru.croc.school.task13;

public class Task13 {

    public static void main(String[] args) {
        final String pathToFilms = "src\\ru\\croc\\school\\task13\\films.txt";
        final String pathToUsers = "src\\ru\\croc\\school\\task13\\users.txt";
        System.out.println(Recommender.recommend(pathToFilms, pathToUsers));

    }
}
