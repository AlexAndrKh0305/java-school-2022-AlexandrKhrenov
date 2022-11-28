package ru.croc.school.task10;
import java.util.Random;

public class User implements Runnable{

    private AuctionLot lot;
    private String userName;

    User(String userName, AuctionLot lot) {
        this.userName = userName;
        this.lot = lot;
    }

    public void run() {
        Random randVar = new Random(System.currentTimeMillis());
        while (!Thread.currentThread().isInterrupted()) {
            lot.changeValue(randVar.nextLong(lot.getCurrentValue() + 1L,lot.getCurrentValue() + 100L), this.userName);
            try {
                Thread.sleep((long) (1e3 / (randVar.nextInt(1, 20))));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
