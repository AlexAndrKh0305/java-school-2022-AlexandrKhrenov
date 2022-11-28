package ru.croc.school.task10;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.time.LocalDateTime;

public class User implements Runnable{

    private static final Object lock = new Object();
    private static AuctionLot lot;
    String userName;

    User(String userName) {
        this.userName = userName;
    }

    public static void setAuctionLot(AuctionLot startedLot) {
        lot = startedLot;
    }

    public static AuctionLot getLot() {
        return lot;
    }

    public void run() {
        Random randVar = new Random(System.currentTimeMillis());
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                lot.changeValue(randVar.nextLong(lot.getCurrentValue() + 1L,lot.getCurrentValue() + 100L), this.userName);
            }
            try {
                Thread.sleep((long) (1e3 / (randVar.nextInt(1, 20))));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
