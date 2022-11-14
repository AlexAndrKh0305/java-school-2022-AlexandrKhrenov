package ru.croc.school.task5;
import ru.croc.school.task4.Rectangle;
import ru.croc.school.task5.Movable;

class NewRectangle extends Rectangle implements Movable{

    NewRectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public boolean ifContainsPoint(double x, double y) {
        if (this.getX1() <= x && x <= this.getX2() && this.getY1() <= y && y <= this.getY2()) {
            return true;
        }
        return false;
    }

    public void move(double dx, double dy) {
        this.setX1(this.getX1() + dx);
        this.setX2(this.getX2() + dx);
        this.setY1(this.getY1() + dy);
        this.setY2(this.getY2() + dy);
    }
}
