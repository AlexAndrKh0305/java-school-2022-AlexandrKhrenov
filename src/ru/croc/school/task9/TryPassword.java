package ru.croc.school.task9;
import java.util.concurrent.Callable;
import ru.croc.school.task9.HashPasswordBuilder;

public class TryPassword implements Callable<String> {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final long startCode;
    private final long step;
    private final int numberOfThreads;
    private static String hashPassword;

    TryPassword(long startCode, long step, int numberOfThreads, String hashPassword) {
        this.startCode = startCode;
        this.step = step;
        this.numberOfThreads = numberOfThreads;
        this.hashPassword = hashPassword;
    }

    public String call() {

        String currentPassword;
        for (long currentCode = this.startCode; currentCode <
                this.startCode + this.step; currentCode++) {
            StringBuilder currentPasswordSB = new StringBuilder();
            long currentCodeCopy = currentCode;

            while (currentCodeCopy != 0) {
                currentPasswordSB.append(alphabet.charAt((int) (currentCodeCopy % (alphabet.length()))));
                currentCodeCopy /= alphabet.length();
            }

            currentPassword = currentPasswordSB.toString();

            StringBuilder reversed = new StringBuilder();
            for (int i = currentPassword.length() - 1; i>= 0; i--) {
                reversed.append(currentPassword.charAt(i));
            }
            currentPassword = reversed.toString(); // torraC

            if (hashPassword.equals(HashPasswordBuilder.hashPassword(currentPassword))) {
                return currentPassword;
            }
        }
        return null;
    }
}
