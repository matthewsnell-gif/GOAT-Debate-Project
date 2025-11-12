import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public final class WordCounter {
        //Helper class which each word and the number of times it appears
        private static class WordCount{
           String word;
           int count;

           //Constructor
           WordCount(String word, int count){
               this.word = word;
               this.count = count;
           }
       }
       //Counts how many times a word appears in the file with removed Stopwords
        public static void CountPlayerWords(List<String> CleanedWords) {
            Map<String, Integer> frequency = new HashMap<>();
            // loop through every single word + count frequencies
            for (String word : CleanedWords) {
                if (word == null || word.isEmpty()) {
                    continue;
                }
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
            //Separate Lists for eventual analysis
            List<Integer>WordCount = new ArrayList<>(frequency.values());
            List<String> UniqueWords = new ArrayList<>();

            //Find all words which only appear once
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() == 1) {
                    UniqueWords.add(entry.getKey());
                }
            }
            //print results
            System.out.println("Word Count: " + WordCount.size());
            System.out.println("Unique Words: " + UniqueWords.size());
        }
    //Builds a ranked list of words and how many times they appear in the file
    public static void WordCountList(List<String> CleanedWords) {
        ArrayList<WordCount> wordCountList = new ArrayList<>();

        //loops through every word to track frequency
        for (String word : CleanedWords) {
            if (word == null || word.isEmpty()) {
                continue;
            }
            boolean found = false;

            //Check if the word previously exists
            for (WordCount wordCount : wordCountList) {
                if (wordCount.word.equals(word)) {
                    wordCount.count++;
                    found = true;
                    break;
                }
            }
            //If it doesn't previously exist, add it to the list starting at 1
            if (!found) {
                wordCountList.add(new WordCount(word, 1));
            }
        }
        //Bubble sort to sort the list in descending order
        for (int i = 0; i < wordCountList.size() - 1; i++) {
            for (int j = 0; j < wordCountList.size() - 1; j++) {
                if (wordCountList.get(j).count < wordCountList.get(j + 1).count) {
                    WordCount temp = wordCountList.get(j);
                    wordCountList.set(j, wordCountList.get(j + 1));
                    wordCountList.set(j + 1, temp);
                }
            }
        }
        //Print results
        System.out.println("Word Ranking by Frequency: ");
        for (WordCount wordCount : wordCountList) {
            System.out.println(wordCount.word + ": " + wordCount.count);
        }
    }
}

