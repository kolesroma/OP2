package com.team6;

public class ProgressionThread implements Runnable{
    @Override
    public void run() {
        long result = 0;
        for (int i = 6; i < 2_000_000_000; i += 6) {
            result += i;
        }

    }
}
