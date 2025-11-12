import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public final class ReadFile {
    private static Map<String, List<String>> files = Map.of(
            "Curry", Arrays.asList(
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Curry1.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Curry2.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Curry3.txt"
            ),
            "James", Arrays.asList(
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron1.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron2.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron3.txt"
            ),
            "Jordan", Arrays.asList(
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/MJ1.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/MJ2.txt",
                    "/Users/mattsnell/GOAT-Debate-Project/txtFiles/MJ3.txt"
            )
    );

    private ReadFile() {
    }

    public static List<String> getWords(String playerKey) {
        List<String> paths = files.get(playerKey);
        if (paths == null) {
            throw new IllegalArgumentException("Unknown Key: " + playerKey + " (expected one of " + files.keySet() + ")");
        }

        List<String> words = new ArrayList<>();
        for (String p : paths) {
            words.addAll(readOne(p));
        }
        return words;
    }

    public static List<String> getWords(String playerKey, int fileIndex) {
        List<String> paths = files.get(playerKey);
        if (paths == null) {
            throw new IllegalArgumentException("Unknown Key: " + playerKey + " (expected one of " + files.keySet() + ")");
        }
        if (fileIndex < 0 || fileIndex >= paths.size()) {
            throw new IndexOutOfBoundsException("index out of bounds: " + (paths.size() - 1));
        }
        return readOne(paths.get(fileIndex));
    }

    public static List<String> getWordsFromPath(String path) {
        return readOne(path);
    }

    private static List<String> readOne(String path) {
        List<String> out = new ArrayList<>();
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                out.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Couldn't open file" + path, e);
        }
        return out;
    }
}
