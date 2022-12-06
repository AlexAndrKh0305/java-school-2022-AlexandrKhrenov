package ru.croc.school.task13;
import java.util.Objects;

public class Film {

    private Integer filmID;
    private String filmTitle;

    public Film(Integer filmID, String filmTitle) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
    }

    public Integer getFilmID() {
        return this.filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Film))
            return false;

        Film film = (Film) obj;
        return this.filmID.equals(film.getFilmID()) &&
                this.filmTitle.equals(film.getFilmTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.filmID, this.filmTitle);
    }

    @Override
    public String toString() {
        return this.filmID + " - " + this.filmTitle;
    }
}
