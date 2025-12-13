import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public final class WordCounter {
    /**
     * private constructor to prevent instantiation of this utility class
     */
    private WordCounter() {}

    /**
     * Counts the total number of words in a list (non-null, non-empty)
     * @param words the list of words to count
     * @return the total number of valid words
     */
    public static int countWords(List<String> words) {
        int total = 0;
        for (String word : words) {
            if (word==null) {
                continue;
            }
            word = word.trim();
            if (word.isEmpty()) {
                continue;
            }
            total++;
        }
        return total;
    }


    public static Map<String, Integer> countFrequencies(List<String> words) {
        Map<String,Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word==null) {
                continue;
            }
            word = word.trim();
            if (word.isEmpty()) {
                continue;
            }
            freq.put(word, freq.getOrDefault(word,0) + 1);
        }
        return freq;
    }

    /**
     * Count how many times unique words appear exactly once
     * @param freq the amount of times a word appears
     * @return each word's frequency
     */
    public static int countAppearingOnce(Map<String, Integer> freq) {
        int once = 0;
        for (int c : freq.values()) {
            if (c == 1) {
                once++;
            }
        }
        return once;
    }

    /**
     * Ranks words by frequency in descending order
     * @param freq a map of word frequencies
     * @return a list of map entries sorted from highest to lowest frequency
     */
    public static List<Map.Entry<String, Integer>> rankFrequency(Map<String, Integer> freq) {
        List<Map.Entry<String, Integer>> ranked = new ArrayList<>(freq.entrySet());
        ranked.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> Integer.compare(b.getValue(), a.getValue()));
        return ranked;
    }

}

