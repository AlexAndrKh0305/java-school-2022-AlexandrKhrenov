package ru.croc.school.task2;
import java.util.Scanner;
import java.util.Locale;

public class Task2 {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in).useLocale(Locale.US);// Locale.US для чисел через точку
        double sum = 0.0; //sum - Сумма прогрессии
        System.out.print("First element: ");
        double a0 = input.nextDouble(); //a0 - начальный элемент
        System.out.print("Difference: ");
        double d = input.nextDouble(); //d - разность арифметической прогрессии
        System.out.print("Amount of elements: ");
        int n = input.nextInt(); //n - количество членов арифметической прогрессии
        double nextA = a0;
        for (int i = 0; i < n; i++) {
            sum += nextA;
            nextA += d;
        }
        System.out.print("Sum: ");
        System.out.println(sum);
    }
}