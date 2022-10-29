package ru.croc.school.task2;
import java.util.Scanner;

public class Task2 {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        long sum = 0L; //sum - Сумма прогрессии
        System.out.print("First element: ");
        long a0 = input.nextLong(); //a0 - начальный элемент
        System.out.print("Difference: ");
        long d = input.nextLong(); //d - разность арифметической прогрессии
        System.out.print("Amount of elements: ");
        long n = input.nextLong(); //n - количество членов арифметической прогрессии
        for (int i = 1; i <= n; i++) {
            sum += a0 + d * (i - 1);
        }
        System.out.print("Sum: ");
        System.out.println(sum);
    }
}