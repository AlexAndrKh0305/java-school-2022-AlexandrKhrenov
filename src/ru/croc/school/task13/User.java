package ru.croc.school.task13;
import java.util.*;

public class User {

    private List<Film> historyOfFilms;

    public User(List<Film> historyOfFilms) {
        this.historyOfFilms = new ArrayList<>(historyOfFilms);
    }

    public List<Film> getHistoryOfFilms() {
        return new ArrayList<>(this.historyOfFilms);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof User))
            return false;

        User user = (User) obj;
        return this.historyOfFilms.equals(user.getHistoryOfFilms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.historyOfFilms);
    }

    public Set<Film> getSetOfHistoryOfFilms() {
        return new HashSet<>(this.historyOfFilms);
    }

    public boolean ifAtLeastHalf(User anotherUser) {
        int countOfTheSameFilms = 0;
        Set<Film> setOfHistoryOfFilms = this.getSetOfHistoryOfFilms();

        for (Film film : anotherUser.getSetOfHistoryOfFilms()) {
            if (setOfHistoryOfFilms.contains(film))
                countOfTheSameFilms++;
        }

        return setOfHistoryOfFilms.size() <= 2 * countOfTheSameFilms;
    }

    public Set<Film> notWatchedFilms(Map<Integer, Film> allFilms) {
        Set<Film> setOfHistoryOfFilms = this.getSetOfHistoryOfFilms();
        Set<Film> setOfAllFilms = new HashSet<>(allFilms.values());
        Set<Film> setOfNotWatchedFilms = new HashSet<>();

        for (Film film : setOfAllFilms) {
            if (!setOfHistoryOfFilms.contains(film))
                setOfNotWatchedFilms.add(film);
        }

        return setOfNotWatchedFilms;
    }
}
