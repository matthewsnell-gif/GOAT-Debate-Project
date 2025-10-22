import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLebronFiles {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron1.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        try {
            File file = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron2.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        try {
            File file = new File("/Users/mattsnell/GOAT-Debate-Project/txtFiles/Lebron3.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

