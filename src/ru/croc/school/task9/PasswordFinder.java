package ru.croc.school.task9;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PasswordFinder {

    private int numberOfThreads, passwordLength;
    private String hashPassword;
    private ExecutorService pool;
    private Future<String>[] threadsAnswers;

    PasswordFinder (int numberOfThreads, int passwordLength, String hashPassword) {
        this.numberOfThreads = numberOfThreads;
        this.passwordLength = passwordLength;
        this.hashPassword = hashPassword;
        this.pool = Executors.newFixedThreadPool(this.numberOfThreads);
        this.threadsAnswers = new Future[this.numberOfThreads];
    }

    public String findPasswordParallel() throws ExecutionException, InterruptedException {
        long step = (long) ((long) Math.pow(26, this.passwordLength) / this.numberOfThreads);
        String answer = null;
        for (int i = 0; i < this.numberOfThreads; i++) {
            threadsAnswers[i] = pool.submit(new TryPassword(i * step, step, this.numberOfThreads, this.hashPassword));
        }
        for (int i = 0; i < this.numberOfThreads; i++) {
            if (threadsAnswers[i].get() != null) {
                answer = threadsAnswers[i].get();
                pool.shutdownNow();
            }
        }
        pool.shutdownNow();
        return answer;
    }


}
