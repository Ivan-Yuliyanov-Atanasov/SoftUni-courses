import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(fileLocation);
        List<String> lines = Files.readAllLines(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_AllCapitalLetters.txt"));
        for (int i = 0; i < lines.size(); i++) {
            String currentLineToUpperCase = lines.get(i).toUpperCase();
            writer.write(currentLineToUpperCase);
            writer.newLine();

        }
        writer.close();
    }
}
