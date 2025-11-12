import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

//Analyzes the file with stopwords already removed, and finds all positive and negative words based on the lexicon scores
public class VocabAnalysis {
    //String Constants for consistent keys
    public static final String POS = "POS";
    public static final String NEG = "NEG";

    //Hashsets which store all pos and neg words from lexicon files
    private HashSet<String> posWords;
    private HashSet<String> negWords;

    //Constructor which loads the pos and neg words from their files
    public VocabAnalysis(String posFile, String negFile) throws IOException {
        posWords = loadWordSet(posFile);
        negWords = loadWordSet(negFile);
    }
    //Reads lexicon file and places all words into a HashSet
    private HashSet<String> loadWordSet(String filePath) throws IOException {
        HashSet<String> wordSet = new HashSet<>();
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNextLine()) {
            //All words to lowercase to match lexicon format
            String line = sc.nextLine().toLowerCase();
            //Ignores blank or comment lines
            if (!line.isEmpty() && !line.startsWith(";")) {
                wordSet.add(line);
            }
        }
        sc.close();
        return wordSet;
    }
    //Counts how many positive and negative words are in the list after being tokenized
    public HashMap<String, Integer> analyzePlayerFile(List<String> wordSet) {
        int pos = 0;
        int neg = 0;
        for (String word : wordSet) {
            //Converts the word to lowercase for matching
            String w = normalize(word);
            if(w.isEmpty()) {
                continue;
            }
            //Searching both lexicon files to find the word to count it
            if(posWords.contains(w)) {
                pos++;
            } else if(negWords.contains(w)) {
                neg++;
            }
        }
        //Store pos and neg words
        HashMap<String, Integer> total = new HashMap<>();
        total.put(POS, pos);
        total.put(NEG, neg);
        return total;
    }
    //Converts words to lowercase for matching
    private String normalize(String word) {
        return word.toLowerCase();
    }
}
