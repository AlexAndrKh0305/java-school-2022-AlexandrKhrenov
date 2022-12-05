package ru.croc.school.task13;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class MyReader {

    private MyReader() {}

    public static Map<Integer, Film> readFilms(String pathToFilms) {
        Map<Integer, Film> allFilms = new HashMap<>();

        try (Scanner s = new Scanner(new FileReader(pathToFilms))) {
            while (s.hasNextLine()) {
                String[] pair = s.nextLine().split(",");
                allFilms.put(Integer.parseInt(pair[0]),
                        new Film(Integer.parseInt(pair[0]), pair[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return allFilms;
    }

    public static List<User> readUsers(String pathToUsers, Map<Integer, Film> allFilms) {
        List<User> users = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(pathToUsers))) {
            while (s.hasNextLine()) {
                List<Film> currentListOfFilms = new ArrayList<>();
                for (String stringFilmID : s.nextLine().split(",")) {
                    currentListOfFilms.add(allFilms.get(Integer.parseInt(stringFilmID)));
                }
                users.add(new User(currentListOfFilms));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static User readRecommendedUser(Map<Integer, Film> allFilms) {
        System.out.print("Enter films id separated by commas: ");
        Scanner input = new Scanner(System.in);
        List<Film> listOfFilms = new ArrayList<>();
        for (String stringFilmID : input.nextLine().split(",")) {
            listOfFilms.add(allFilms.get(Integer.parseInt(stringFilmID)));
        }
        return new User(listOfFilms);
    }
}
