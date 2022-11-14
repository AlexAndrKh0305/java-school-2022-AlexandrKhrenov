package ru.croc.school.task4;

public class Figure {

    private String color = "White";

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean ifContainsPoint(double x, double y) {
        return false;
    }

    @Override
    public String toString() {
        return "Just a Figure";
    }
}
