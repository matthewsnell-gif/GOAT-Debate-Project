import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LebronWordCounter {
    public static void main(String[] args) {
        try {
            File file1 = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron1.txt");
            int wordCount = 0;
            Scanner reader = new Scanner(file1);
            while (reader.hasNext()) {
                reader.next();
                wordCount++;
            }
            reader.close();
            System.out.println("Total words in the 1st Lebron article: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File file2 = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron2.txt");
            int wordCount = 0;
            Scanner reader = new Scanner(file2);
            while (reader.hasNext()) {
                reader.next();
                wordCount++;
            }
            reader.close();
            System.out.println("Total words in the 2nd Lebron article: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File file3 = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron3.txt");
            int wordCount = 0;
            Scanner reader = new Scanner(file3);
            while (reader.hasNext()) {
                reader.next();
                wordCount++;
            }
            reader.close();
            System.out.println("Total words in the 3rd Lebron article: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

