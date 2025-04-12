import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordOccurrenceCounter {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "hello";
        int count = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // remove punctuation
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println("The word \"" + targetWord + "\" occurred " + count + " times.");
    }
}
