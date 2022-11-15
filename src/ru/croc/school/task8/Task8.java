package ru.croc.school.task8;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Task8 {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a double: ");
            double currency = input.nextDouble();
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.print("Result: " + format.format(currency));
        } catch(Exception e) {
            System.out.println("Run the program again and enter a decimal number in the format <dollars,cents>");
        }
    }
}
