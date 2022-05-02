import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(fileLocation);
        int oneByte = inputStream.read();
        int sum = 0;
        while (oneByte != -1){
            char character = (char) oneByte;
            if(character != '\n' && character != '\r'){
                sum += oneByte;
            }

            oneByte = inputStream.read();
        }
        System.out.println(sum);
    }
}
