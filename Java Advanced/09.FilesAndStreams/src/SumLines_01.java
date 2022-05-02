import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(fileLocation);
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            int sum = 0;
            String currentLine = lines.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                sum += currentLine.charAt(j);


            }
            System.out.println(sum);

        }
    }
}
