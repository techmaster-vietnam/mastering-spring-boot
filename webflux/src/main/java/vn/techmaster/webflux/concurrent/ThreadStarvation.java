package vn.techmaster.webflux.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStarvation {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            executorService.execute(() -> {
                System.out.println("Run first");
            });
            System.out.println("Done");
        });
    }
}
