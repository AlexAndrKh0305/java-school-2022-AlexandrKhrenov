package ru.croc.school.task5;
import ru.croc.school.task4.Circle;

class NewCircle extends Circle implements Movable{

    NewCircle(double x0, double y0, double radius) {
        super(x0, y0, radius);
    }

    @Override
    public boolean ifContainsPoint(double x, double y) {
        if ((this.getX0() - x) * (this.getX0() - x) +
                (this.getY0() - y) * (this.getY0() - y) <=
                this.getRadius() * this.getRadius()) {
            return true;
        }
        return false;
    }

    public void move(double dx, double dy) {
        this.setX0(this.getX0() + dx);
        this.setY0(this.getY0() + dy);
    }
}
