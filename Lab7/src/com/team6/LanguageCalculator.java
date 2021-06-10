package com.team6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LanguageCalculator implements Runnable {
    private final String fileName;
    static Map<String, Integer> wordStats = Collections.synchronizedMap(new HashMap<>());

    public LanguageCalculator(String fileName) {
        this.fileName = fileName;
    }

    public static Map<String, Integer> getWordStats() {
        return wordStats;
    }

    @Override
    public void run() {
        try {
            getFileStats(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getFileStats(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null)
            for (String word : line.split(" ")) {
                if (!wordStats.containsKey(word)) {
                    wordStats.put(word, 1);
                } else {
                    wordStats.put(word, wordStats.get(word) + 1);
                }
            }
        br.close();
    }
}
