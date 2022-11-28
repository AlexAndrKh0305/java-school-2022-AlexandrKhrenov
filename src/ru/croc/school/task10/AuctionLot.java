package ru.croc.school.task10;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.io.File;

public class AuctionLot {

    private long currentValue;
    private final String suggestedUser;
    private String winnerName;
    private LocalDateTime auctionFinishedTime;

    AuctionLot(long currentValue, String suggestedUser, LocalDateTime auctionFinishedTime) {
        this.currentValue = currentValue;
        this.suggestedUser = suggestedUser;
        this.auctionFinishedTime = auctionFinishedTime;
    }

    AuctionLot(long currentValue, String suggestedUser) {
        this.currentValue = currentValue;
        this.suggestedUser = suggestedUser;
        this.auctionFinishedTime = LocalDateTime.now().plus(15, ChronoUnit.SECONDS);
    }


    public long getCurrentValue() {
        return this.currentValue;
    }

    public void changeValue(long newValue, String betUser) {
        try (OutputStream out = new FileOutputStream("src\\ru\\croc\\school\\task10\\output.txt", true)) {
            if (newValue > this.currentValue && this.auctionFinishedTime.isAfter(LocalDateTime.now())) {
                String text = "Bet is allowed: User: " + betUser +
                        " Old value: " + this.currentValue + " New value: " + newValue + "\n";
                out.write(text.getBytes(StandardCharsets.UTF_8));
                this.currentValue = newValue;
                this.winnerName = betUser;
            } else {
                String text = "Bet is prohibited: User: " + betUser + " Old value: " + this.currentValue +
                        " New value: " + newValue + " Comment: ";
                out.write(text.getBytes(StandardCharsets.UTF_8));
                if (!(newValue > this.currentValue)) {
                    text = "Value must be greater!\n";
                    out.write(text.getBytes(StandardCharsets.UTF_8));
                } else {
                    text = "Time is over!\n";
                    out.write(text.getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWinnerName(){
        return this.winnerName;
    }

    public LocalDateTime getAuctionFinishedTime() {
        return this.auctionFinishedTime;
    }
}
