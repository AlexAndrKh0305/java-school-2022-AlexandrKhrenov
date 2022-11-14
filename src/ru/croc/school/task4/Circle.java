package ru.croc.school.task4;
import ru.croc.school.task4.Figure;

public class Circle extends Figure{

    private double x0, y0, radius;

    public Circle(double x0, double y0, double radius) {
        super();
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public double getX0() {
        return this.x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return this.y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle (" + this.x0 + ", " + this.y0 + "), " +
                this.radius;
    }
}
