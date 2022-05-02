import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        Scanner scan = new Scanner(new FileInputStream(fileLocation));

        Map<String, Integer> map = new LinkedHashMap<>();

        while (scan.hasNext()){
            String word = scan.next();

            map.put(word,0);


        }
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputWordCount.txt"));
        while(scanner.hasNext()){
            String wordToCheck = scanner.next();
            if(map.containsKey(wordToCheck)){
                map.put(wordToCheck,map.get(wordToCheck) + 1);
            }
        }
        map.entrySet().stream()
                .sorted((w1,w2) -> Integer.compare(w2.getValue(),w1.getValue()))
                .forEach(w-> {
                    try {
                        writer.write(w.getKey() + " - " + w.getValue());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();

    }
}
