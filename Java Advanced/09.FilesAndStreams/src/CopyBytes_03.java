import java.io.*;
import java.util.Set;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        FileInputStream InputStream = new FileInputStream(path);
        PrintStream outputFile = new PrintStream("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");
//        Set<Character> lookupList = Set.of(' ','\r','\n');
        int oneByte = InputStream.read();
        while(oneByte != -1){
            if(oneByte == 32){
                outputFile.print((char)oneByte);
            } else if(oneByte == 10){
                outputFile.println();
            } else {
                outputFile.print(oneByte);
            }

            oneByte = InputStream.read();
        }
    }
}
