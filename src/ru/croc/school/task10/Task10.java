package ru.croc.school.task10;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Task10 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of users(less or equal 20000): ");
        int userCount = input.nextInt();
        System.out.print("Enter the first value of auction lot: ");
        long firstValue = input.nextLong();
        String winnerName;
        long totalValue;

        AuctionLot startedLot = new AuctionLot(firstValue, "Suggested user");
        Thread[] users = new Thread[userCount];

        try (OutputStream out = new FileOutputStream("src\\ru\\croc\\school\\task10\\output.txt")) {
            out.write("".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < userCount; i++) {
            Thread currentUser = new Thread(new User("user" + (i + 1), startedLot));
            users[i] = currentUser;
            users[i].start();
        }

        int counter = 0;
        while (true) {
            if (counter == 0) {
                System.out.println("running...");
            }
            counter = (counter + 1) % 100_000_000;
            if (startedLot.getAuctionFinishedTime().isBefore(LocalDateTime.now())) {
                winnerName = startedLot.getWinnerName();
                totalValue = startedLot.getCurrentValue();
                for (int i = 0; i < userCount; i++) {
                    users[i].interrupt();
                }
                break;
            }
        }
        System.out.println("Winner: " + winnerName + " Total value: " + totalValue);
    }
}
