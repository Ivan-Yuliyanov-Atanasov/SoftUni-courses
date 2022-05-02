import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(fileLocation);
        List<String> lines = Files.readAllLines(path);
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                char symbol = currentLine.charAt(j);

                if(symbol == '!' || symbol == '?' || symbol == ','){
                    punctuation++;
                } else if (symbol == '\n' || symbol == '\r' || symbol == ' '){
                    continue;
                } else if (symbol == 'a'
                           ||symbol == 'o'
                            ||symbol == 'u'
                           ||symbol == 'e'
                        ||symbol == 'i' ){
                    vowels++;

                } else {
                    consonants++;
                }

            }

        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation: " + punctuation);

    }
}
