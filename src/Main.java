import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Select an article you'd like to learn more about!");
        System.out.println("Your options are: \n1. Lebron James\n2. Michael Jordan\n3. Stephen Curry");
        System.out.println("=============================================================================");
        System.out.println("To select a file, type the LAST NAME of the player who you'd like to learn more about.");
        Scanner input = new Scanner(System.in);
        String player = input.nextLine();
        if (!(player.equalsIgnoreCase("James") || player.equalsIgnoreCase("Jordan") || player.equalsIgnoreCase("Curry"))) {
            throw new IllegalArgumentException("Please enter a valid player name.");
        }
        System.out.println("Each player has 3 files, to choose one, type a number 0 through 2 (for indexes): ");
        int file = input.nextInt();
        if (file < 0 || file > 2) {
            System.err.println("Please select a number between 0 and 2.");
        }

        //Relative Paths
        String stopwordPath = Paths.get("txtFiles", "stopwords.txt").toString();
        String posPath = Paths.get("txtFiles", "positive-words.txt").toString();
        String negPath = Paths.get("txtFiles", "negative-words.txt").toString();

        try {
            //Clean Words
            List<String> words = ReadFile.getWords(player, file);
            List<String> CleanedWords = WordRemover.removeStopwords(words, stopwordPath);

            //Vocab Analysis
            VocabAnalysis analysis = new VocabAnalysis(posPath, negPath);
            HashMap<String, Integer> sentiment = analysis.analyzePlayerFile(CleanedWords);

            int pos = sentiment.get(VocabAnalysis.POS);
            int neg = sentiment.get(VocabAnalysis.NEG);

            System.out.println("The positive words are: " + pos);
            System.out.println("The negative words are: " + neg);
            System.out.println();

            //Ranks words by frequencies
            Map<String, Integer> frequency = WordCounter.countFrequencies(CleanedWords);

            int once = WordCounter.countAppearingOnce(frequency);


            System.out.println("Total Words (After Stopwords): " + CleanedWords.size());
            System.out.println("Word Frequencies: " + frequency.size());
            System.out.println("Total Words Appearing Once: " + once);
            System.out.println();

            System.out.println("Ranking Words by Frequency: ");
            for (Map.Entry<String, Integer> entry : WordCounter.rankFrequency(frequency)) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println();
            if (pos > neg) {
                System.out.println("The Overall Tone of this Article was positive!");
            } else if (pos < neg) {
                System.out.println("The Overall Tone of this Article was negative.");
            } else  {
                System.out.println("The Overall Tone of this Article was neutral");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
