package ru.croc.school.task4;
import java.util.Scanner;
import java.util.Locale;

public class Task4 {

    class AnnotatedImage {

        private final String imagePath;

        private final Annotation[] annotations;



        public AnnotatedImage(String imagePath, Annotation... annotations) {
            this.imagePath = imagePath;
            this.annotations = annotations;
        }

        public String getImagePath() {
            return this.imagePath;
        }

        public Annotation[] getAnnotations() {
            return this.annotations;
        }
    }


    static class Annotation {

        private String text;
        private Figure figure;

        Annotation(String text, Figure figure) {
            this.text = text;
            this.figure = figure;
        }

        @Override
        public String toString() {
            String ans = "";
            if (this.figure instanceof Rectangle) {
                ans = "Rectangle (" + ((Rectangle) this.figure).getX1() + ", ";
                ans += ((Rectangle) this.figure).getY1() + "), (";
                ans += ((Rectangle) this.figure).getX2() + ", " + ((Rectangle) this.figure).getY2() + "): ";
                ans += text;
            }
            else if (this.figure instanceof Circle){
                ans = "Circle (" + ((Circle) this.figure).getX0() + ", ";
                ans += ((Circle) this.figure).getY0() + ") ";
                ans += ((Circle) this.figure).getRadius() + ": ";
                ans += text;
            }
            return ans;
        }

    }

    static class Figure {

        protected String color = "White";

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }

    static class Rectangle extends Figure {

        private double x1, y1, x2, y2;

        Rectangle(double x1, double y1, double x2, double y2) {
            super();
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double getX1() {
            return this.x1;
        }

        public double getY1() {
            return this.y1;
        }

        public double getX2() {
            return this.x2;
        }

        public double getY2() {
            return this.y2;
        }

    }

    static class Circle extends Figure {

        private double x0, y0, radius;

        Circle(double x0, double y0, double radius) {
            super();
            this.x0 = x0;
            this.y0 = y0;
            this.radius = radius;
        }

        public double getX0() {
            return this.x0;
        }

        public double getY0() {
            return this.y0;
        }

        public double getRadius() {
            return this.radius;
        }

    }

    public static void main(String[] args) {

        // Example 1
        Rectangle rectangle = new Rectangle(100, 100, 150, 200);
        Annotation annotation1 = new Annotation("Car", rectangle);
        System.out.println(annotation1);

        // Example 2
        Circle circle = new Circle(100, 100, 10);
        Annotation annotation2 = new Annotation("Tree", circle);
        System.out.println(annotation2);



    }

}
