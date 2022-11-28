package ru.croc.school.task10;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;
import ru.croc.school.task10.AuctionLot;


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
        User.setAuctionLot(startedLot);
        Thread[] users = new Thread[userCount];

        try (OutputStream out = new FileOutputStream("src\\ru\\croc\\school\\task10\\output.txt")) {
            out.write("".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < userCount; i++) {
            Thread currentUser = new Thread(new User("user" + (i + 1)));
            users[i] = currentUser;
            users[i].start();
        }

        int counter = 0;
        while (true) {
            if (counter == 0) {
                System.out.println("running...");
            }
            counter = (counter + 1) % 100_000_000;
            if (User.getLot().getAuctionFinishedTime().isBefore(LocalDateTime.now())) {
                winnerName = User.getLot().getWinnerName();
                totalValue = User.getLot().getCurrentValue();
                for (int i = 0; i < userCount; i++) {
                    users[i].interrupt();
                }
                break;
            }
        }
        System.out.println("Winner: " + winnerName + " Total value: " + totalValue);
    }
}
