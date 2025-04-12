import java.io.*;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "output.txt"; 
        try (
          
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);

            FileWriter writer = new FileWriter(filePath)
        ) {
            System.out.println("Enter text (type 'exit' to finish):");

            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(inputLine + System.lineSeparator());
            }

            System.out.println("Input successfully written to " + filePath);

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
