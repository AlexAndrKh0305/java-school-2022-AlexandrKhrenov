package ru.croc.school.task13;

import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) {

        final String pathToFilms = "src\\ru\\croc\\school\\task13\\films.txt";
        final String pathToUsers = "src\\ru\\croc\\school\\task13\\users.txt";
        System.out.print("Enter films id separated by commas: ");
        Scanner input = new Scanner(System.in);
        String viewingHistory = input.nextLine();
        System.out.println(Recommender.recommend(pathToFilms, pathToUsers, viewingHistory));
    }
}
