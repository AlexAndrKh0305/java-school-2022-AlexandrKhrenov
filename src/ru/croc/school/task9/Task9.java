package ru.croc.school.task9;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import ru.croc.school.task9.HashPasswordBuilder;
import ru.croc.school.task9.PasswordFinder;

public class Task9 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //System.out.println(HashPasswordBuilder.hashPassword("qcs")); //855F4471C5BD9FB01E7F56BFC0D7F48B

        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Number of threads: ");
        int numberOfThreads = input.nextInt();
        input.nextLine();

        System.out.print("Input hash password: ");
        String inputHashPassword = input.nextLine();

        PasswordFinder finder = new PasswordFinder(numberOfThreads,
                7, inputHashPassword);//When checking, replace 7 with 3
        System.out.println(finder.findPasswordParallel());
    }
}
