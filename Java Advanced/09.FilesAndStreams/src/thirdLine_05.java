import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class thirdLine_05 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        Path path = Path.of(fileLocation);
        List<String> lines = Files.readAllLines(path);
        PrintStream outputFile = new PrintStream("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput");

        for (int i = 1; i < lines.size(); i++) {
            if(i % 3 == 0){
                outputFile.println(lines.get(i - 1));
            }

        }



    }
}
