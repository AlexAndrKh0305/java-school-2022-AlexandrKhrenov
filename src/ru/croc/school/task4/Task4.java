package ru.croc.school.task4;
import java.util.Scanner;
import java.util.Locale;
import ru.croc.school.task4.Annotation;
import ru.croc.school.task4.Circle;
import ru.croc.school.task4.Rectangle;

public class Task4 {

    public static void main(String[] args) {

        Circle f1 = new Circle(5, 6, 9.5);
        Annotation ann1 = new Annotation("First: Ben writes a letter", f1);

        Rectangle f2 = new Rectangle(-3, -7, 0, 1);
        Annotation ann2 = new Annotation("Second: Maria is cooking dinner", f2);

        Circle f3 = new Circle(-10.35, -30, 3);
        Annotation ann3 = new Annotation("Third: Peter rides a bike", f3);

        Rectangle f4 = new Rectangle(7, 5, 42, 30);
        Annotation ann4 = new Annotation("Fourth: Jack has had dinner yet", f4);

        Rectangle f5 = new Rectangle(-15.25, -32, 2, 0);
        Annotation ann5 = new Annotation("Fifth: Ben does sports every day", f5);

        Circle f6 = new Circle(-12, -31, 50);
        Annotation ann6 = new Annotation("Sixth: John is watching movie", f6);

        Annotation[] annotations = {ann1, ann2, ann3, ann4, ann5, ann6};

        AnnotatedImage annImage = new AnnotatedImage("ru.croc.school.somepath", annotations);

        for (Annotation ann : annImage.getAnnotations()) {
            System.out.println(ann);
        }
    }

}