package ru.croc.school.task4;
import ru.croc.school.task4.Figure;

public class Rectangle extends Figure {

    private double x1, y1, x2, y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return this.x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return this.y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return this.x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return this.y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Rectangle (" + this.x1 + ", " + this.y1 +
                "), (" + this.x2 + ", " + this.y2 + ")";
    }
}