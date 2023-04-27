package Task2;
import java.io.*;
import java.util.*;
public class UniqueWordsFinder {
    public static HashSet<String> findUniqueWords(String fileName) {
        HashSet<String> allWords = new HashSet<>();
        HashSet<String> uniqueWords = new HashSet<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String[] words = scanner.next().toLowerCase().split("[^a-zA-Z]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (allWords.contains(word)) {
                            uniqueWords.remove(word);
                        } else {
                            allWords.add(word);
                            uniqueWords.add(word);
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return uniqueWords;
    }
}