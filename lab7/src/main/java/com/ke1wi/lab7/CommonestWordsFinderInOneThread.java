package com.ke1wi.lab7;

import java.io.*;
import java.util.*;

public class CommonestWordsFinderInOneThread {
    public static void main(String[] args) {
        String[] filenames = {
                "src/main/resources/long.txt",
                "src/main/resources/long2.txt",
                "src/main/resources/long3.txt",
                "src/main/resources/long31.txt",
                "src/main/resources/long32.txt",
                "src/main/resources/long33.txt",
                "src/main/resources/long34.txt",
                "src/main/resources/lorem1.txt",
                "src/main/resources/lorem2.txt",
                "src/main/resources/lorem3.txt"
        };

        for (String filename : filenames) {
            try {
                Map<String, Integer> wordFrequency = countWords(filename);
                List<String> commonestWords = findCommonestWords(wordFrequency);
                System.out.printf("\nFile: %s\nCommonest word(s): %s\n\n", filename, commonestWords);
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static Map<String, Integer> countWords(String filename) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordFrequency;
    }

    private static List<String> findCommonestWords(Map<String, Integer> wordFrequency) {
        int maxFrequency = Collections.max(wordFrequency.values());
        List<String> commonestWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                commonestWords.add(entry.getKey());
            }
        }
        return commonestWords;
    }
}
