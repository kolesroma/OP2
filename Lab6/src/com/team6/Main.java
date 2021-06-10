package com.team6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("count by loop");
        long startTime = System.nanoTime();
        long result = countArithmeticProgressionLoop();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount by formula");
        startTime = System.nanoTime();
        result = countArithmeticProgressionFormula();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount with 2 threads");
        for (int i = 1; i < 2; i++)
            new Thread(new ProgressionThread()).join();
        startTime = System.nanoTime();
        new Thread(new ProgressionThread()).start();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount with 4 threads");
        for (int i = 1; i < 4; i++)
            new Thread(new ProgressionThread()).join();
        startTime = System.nanoTime();
        new Thread(new ProgressionThread()).start();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount with 8 threads");
        for (int i = 1; i < 8; i++)
            new Thread(new ProgressionThread()).join();
        startTime = System.nanoTime();
        new Thread(new ProgressionThread()).start();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount with 16 threads");
        for (int i = 1; i < 16; i++)
            new Thread(new ProgressionThread()).join();
        startTime = System.nanoTime();
        new Thread(new ProgressionThread()).start();
        System.out.println(System.nanoTime() - startTime + "ns");

        System.out.println("\ncount with 32 threads");
        for (int i = 1; i < 32; i++)
            new Thread(new ProgressionThread()).join();
        startTime = System.nanoTime();
        new Thread(new ProgressionThread()).start();
        System.out.println(System.nanoTime() - startTime + "ns");
    }

    public static long countArithmeticProgressionLoop() {
        long result = 0;
        for (int i = 6; i < 2_000_000_000; i += 6) {
            result += i;
        }
        return result;
    }

    public static long countArithmeticProgressionFormula() {
        return (long) (6 + 2_000_000_000) * 166666666;
    }
}
