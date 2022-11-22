package ru.croc.school.task10;
import java.time.LocalDateTime;
import java.util.Scanner;
import ru.croc.school.task10.AuctionLot;


public class Task10 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userCount = input.nextInt();
        long firstValue = input.nextLong();

        AuctionLot lot = new AuctionLot(firstValue, "Some name");
        Thread[] users = new Thread[userCount];
        for (int i = 0; i < userCount; i++) {
            Thread currentUser = new Thread(new User(lot, "user" + i));
            users[i] = currentUser;
            users[i].start();
        }
        while (true) {
            if (lot.getAuctionFinishedTime() < LocalDateTime.now()) {
                lot.winnerName();
                for (int i = 0; i < userCount; i++) {
                    users[i].interrupt();
                }
                break;
            }
        }

    }
}
