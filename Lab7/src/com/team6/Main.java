package com.team6;

public class Main {
    public static void main(String[] args) {
        Thread tA = new Thread(new LanguageCalculator("fileA.txt"));
        Thread tB = new Thread(new LanguageCalculator("fileB.txt"));
        Thread tC = new Thread(new LanguageCalculator("fileC.txt"));
        Thread tD = new Thread(new LanguageCalculator("fileD.txt"));
        Timer timer = new Timer();
        timer.start();
        tA.start();
        tB.start();
        tC.start();
        tD.start();

        try {
            tA.join();
            tB.join();
            tC.join();
            tD.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        timer.stopAndShow();
        System.out.println(LanguageCalculator.getWordStats());
    }
}
