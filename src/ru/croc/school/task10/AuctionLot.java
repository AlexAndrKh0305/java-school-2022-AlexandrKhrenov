package ru.croc.school.task10;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AuctionLot {

    private long currentValue;
    private String userName;
    private LocalDateTime auctionFinishedTime;

    AuctionLot(long currentValue, String userName) {
        this.currentValue = currentValue;
        this.userName = userName;
        this.auctionFinishedTime = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);
    }

    public long getCurrentValue() {
        return this.currentValue;
    }

    public void changeValue(long newValue, String userName) {
        if (newValue > this.currentValue) {
            this.currentValue = newValue;
            this.userName = userName;
        }
    }

    public String winnerName(){
        return userName;
    }

    public LocalDateTime getAuctionFinishedTime() {
        return this.auctionFinishedTime;
    }
}
