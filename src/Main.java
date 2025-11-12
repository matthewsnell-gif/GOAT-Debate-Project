import java.io.IOException;
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

        // Access the file from the player variable at index file
        List<String> File = ReadFile.getWords(player, file);
        //create variable to call stopword file
        String stopwordPath = "/Users/mattsnell/GOAT-Debate-Project/txtFiles/stopwords.txt";
        //remove stopwords and print the List of remaining words in article
        List<String> CleanedWords = WordRemover.removeStopwords(File, stopwordPath);


        System.out.println(CleanedWords);
        WordCounter.CountPlayerWords(CleanedWords);

        //analyze the cleaned article and count positive and negative words
        try {
            VocabAnalysis analysis = new VocabAnalysis(
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/positive-words.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/negative-words.txt");

            HashMap<String, Integer> result = analysis.analyzePlayerFile(CleanedWords);
            System.out.println("Positive Words: " + result.get(VocabAnalysis.POS));
            System.out.println("Negative Words: " + result.get(VocabAnalysis.NEG));
            System.out.println(" ");

            //Ranks words by frequencies
            WordCounter.WordCountList(CleanedWords);

            // create variables for the conditional which decides the overall tonality of article
            int pos = result.get(VocabAnalysis.POS);
            int neg = result.get(VocabAnalysis.NEG);

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
