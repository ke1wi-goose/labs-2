package com.ke1wi.lab6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int N = 100_000_000;
        int[] NUM_THREADS = { 2, 4, 8, 16, 32 };
        long startTime, endTime;
        long sum = 0;
        startTime = System.currentTimeMillis();
        sum = sum_by_formula(n, N);
        endTime = System.currentTimeMillis();
        System.out.println(
                "Sum: " + sum + ", Time: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        sum = sum_by_for(n, N);
        endTime = System.currentTimeMillis();
        System.out.println(
                "Sum: " + sum + ", Time: " + (endTime - startTime) + "ms");
        for (int numThreads : NUM_THREADS) {
            startTime = System.currentTimeMillis();
            try {
                sum = calculateSum(numThreads, n, N);
            } catch (InterruptedException e) {
                System.out.println("According to process exception occurs: " + e.getMessage());
            }
            endTime = System.currentTimeMillis();
            System.out.println(
                    "Threads: " + numThreads + ", Sum: " + sum + ", Time: " + (endTime - startTime) + "ms");
        }
    }

    public static long sum_by_formula(int n, long N) {
        return (n * N * (N + 1)) / 2;
    }

    public static long sum_by_for(int n, long N) {
        long res = 0;

        for (int i = 1; i <= N; i++) {
            res += i * n;
        }
        return res;
    }

    public static long calculateSum(int numThreads, int n, long N) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        AtomicLong totalSum = new AtomicLong(0);

        for (int i = 0; i < numThreads; i++) {
            final int threadNum = i;
            executor.submit(() -> {
                long partialSum = 0;
                for (int j = threadNum + 1; j <= N; j += numThreads) {
                    partialSum += j * n;
                }
                totalSum.addAndGet(partialSum);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        return totalSum.get();
    }
}