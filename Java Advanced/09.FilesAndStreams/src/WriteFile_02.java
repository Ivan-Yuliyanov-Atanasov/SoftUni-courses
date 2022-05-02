import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class WriteFile_02 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        FileInputStream InputStream = new FileInputStream(path);
        OutputStream outputFile = new FileOutputStream("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");
        Set <Character> lookupList = Set.of(',','.','!','?');
        int oneByte = InputStream.read();
        while(oneByte != -1){
            if(!lookupList.contains((char)oneByte)){
                outputFile.write(oneByte);
            }

            oneByte = InputStream.read();
        }
    }
}
