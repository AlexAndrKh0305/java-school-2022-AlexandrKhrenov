package ru.croc.school.task16;
import java.util.HashSet;
import java.util.Set;

public class Driver {

    private String name;
    private double width, length;
    private String comfortClass;
    private Set<String> otherThings;

    Driver(String name, double width, double length, String comfortClass, Set<String> otherThings) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.comfortClass = comfortClass;
        this.otherThings = new HashSet<>(otherThings);
    }

    public double distance (double x, double y) {
        return Math.pow(Math.pow(this.width - x, 2) + Math.pow(this.length - y, 2), 0.5);
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return length;
    }

    public String getComfortClass() {
        return comfortClass;
    }

    public Set<String> getOtherThings() {
        return new HashSet<>(this.otherThings);
    }
}
