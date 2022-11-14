package ru.croc.school.task4;
import ru.croc.school.task4.Figure;


public class Annotation {

    private String text;
    private Figure figure;

    public Annotation(String text, Figure figure) {

        this.text = text;
        this.figure = figure;

    }

    public String getText() {

        return this.text;

    }

    public void setText(String text) {

        this.text = text;

    }

    public Figure getFigure() {

        return this.figure;

    }

    public void setFigure(Figure figure) {

        this.figure = figure;

    }

    @Override
    public String toString() {

        return this.figure + ": " + this.text;

    }

}
