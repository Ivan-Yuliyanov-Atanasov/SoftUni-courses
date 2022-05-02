import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ListFiles_07 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File [] files = file.listFiles();
        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n",f.getName(),f.length());
            }

        }
    }
}
