import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WordRemover {
    public static List<String> removeStopwords(List<String> inputWords, String stopwordPath) {
        List<String> result = new ArrayList<>(inputWords);
        HashSet<String> stopwords = new HashSet<>();

        try {
            Scanner reader = new Scanner(new File(stopwordPath));
            while (reader.hasNext()) {
                stopwords.add(reader.next());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Stopword file not found" + e.getMessage());
        }
        result.removeIf(stopwords::contains);
        return result;
    }
}

