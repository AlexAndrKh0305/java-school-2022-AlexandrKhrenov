package ru.croc.school.task10;

public class User implements Runnable{

    private static final Object lock = new Object();
    AuctionLot lot;
    String userName;

    User(AuctionLot lot, String userName) {
        this.lot = lot;
        this.userName = userName;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.lot.changeValue((long) (Math.random() + 1) * this.lot.getCurrentValue(), this.userName);
        }
        try {
            Thread.sleep((long) (1e3 / (Math.random() * 20)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
