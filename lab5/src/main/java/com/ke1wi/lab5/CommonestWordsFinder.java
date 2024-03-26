package com.ke1wi.lab5;

import java.io.*;
import java.util.*;

public class CommonestWordsFinder {
    public static void main(String[] args) {
        String filename = "src/main/resources/lorem3.txt";
        try {
            List<String> commonestWords = commonestWords(filename);
            System.out.printf("\nCommonest word(s): %s\n\n", commonestWords);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static List<String> commonestWords(String filename) throws IOException {
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
