package com.team6;

public class Timer {
    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stopAndShow() {
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
