import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        Path path = Path.of(fileLocation);
        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);
        Files.write((Path.of("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt")),lines);

    }
}
