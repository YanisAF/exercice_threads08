package org.example;


import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();
                }
            }); threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Valeur finale du compteur "+counter.get());
    }
}