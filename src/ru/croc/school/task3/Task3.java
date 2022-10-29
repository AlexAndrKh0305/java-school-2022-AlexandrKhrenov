package ru.croc.school.task3;
import java.util.Scanner;
import java.util.Locale;

public class Task3 {

    static class Point {

        double x;
        double y;
    }

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in).useLocale(Locale.US);// Locale.US для чисел через точку

        System.out.print("First coords: ");
        Point a = new Point();
        a.x = input.nextDouble();
        a.y = input.nextDouble();

        System.out.print("Second coords: ");
        Point b = new Point();
        b.x = input.nextDouble();
        b.y = input.nextDouble();

        System.out.print("Third coords: ");
        Point c = new Point();
        c.x = input.nextDouble();
        c.y = input.nextDouble();

        double side1 = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        double side2 = Math.sqrt((c.x - a.x) * (c.x - a.x) + (c.y - a.y) * (c.y - a.y));
        double side3 = Math.sqrt((b.x - c.x) * (b.x - c.x) + (b.y - c.y) * (b.y - c.y));
        double p = (side1 + side2 + side3) / 2;
        double sq = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

        System.out.print("Triangle square: ");
        System.out.print(sq);

    }
}
