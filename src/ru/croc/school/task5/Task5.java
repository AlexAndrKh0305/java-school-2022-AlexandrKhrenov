package ru.croc.school.task5;
import java.util.Scanner;
import java.util.Locale;
import ru.croc.school.task5.NewAnnotatedImage;
import ru.croc.school.task4.Annotation;
import ru.croc.school.task5.NewCircle;
import ru.croc.school.task5.NewRectangle;


public class Task5 {

    public static void main(String[] args) {

        NewCircle f1 = new NewCircle(5, 6, 9.5);
        Annotation ann1 = new Annotation("First: Ben writes a letter", f1);

        NewRectangle f2 = new NewRectangle(-3, -7, 0, 1);
        Annotation ann2 = new Annotation("Second: Maria is cooking dinner", f2);

        NewCircle f3 = new NewCircle(-10.35, -30, 3);
        Annotation ann3 = new Annotation("Third: Peter rides a bike", f3);

        NewRectangle f4 = new NewRectangle(7, 5, 42, 30);
        Annotation ann4 = new Annotation("Fourth: Jack has had dinner yet", f4);

        NewRectangle f5 = new NewRectangle(-15.25, -32, 2, 0);
        Annotation ann5 = new Annotation("Fifth: Ben does sports every day", f5);

        NewCircle f6 = new NewCircle(-12, -31, 50);
        Annotation ann6 = new Annotation("Sixth: John is watching movie", f6);

        Annotation[] annotations = {ann1, ann2, ann3, ann4, ann5, ann6};

        NewAnnotatedImage annImage1 = new NewAnnotatedImage("ru.croc.school.somepath", annotations);

        //Searching Annotation by label
        System.out.println("Searching Annotation by label:");
        System.out.println("dinner:");
        System.out.println(annImage1.findByLabel("dinner"));
        System.out.println("John:");
        System.out.println(annImage1.findByLabel("John"));
        System.out.println();

        //Searching Annotation by point
        System.out.println("Searching Annotation by point:");
        System.out.println("(-11, -29)");
        System.out.println(annImage1.findByPoint(-11, -29));
        System.out.println();

        //Moving some Figures
        System.out.println("Moving some Figures");
        System.out.println("Move third Annotation (100, 100)");
        f3.move(100, 100);
        ann3.setFigure(f3);
        System.out.println("Move fourth Annotation (-3, -5)");
        f4.move(-3, -5);
        ann4.setFigure(f4);
        System.out.println();

        annotations[2] = ann3;
        annotations[3] = ann4;

        NewAnnotatedImage annImage2 = new NewAnnotatedImage("ru.croc.school.somepath", annotations);

        //Searching Annotation by point
        System.out.println("Searching Annotation by point:");
        System.out.println("(-11, -29)");
        System.out.println(annImage2.findByPoint(-11, -29));
        System.out.println();

        //All Annotations
        System.out.println("All Annotations:");
        for (Annotation ann : annImage2.getAnnotations()) {
            System.out.println(ann);
        }

    }

}