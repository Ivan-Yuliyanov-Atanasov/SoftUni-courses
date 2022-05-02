import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        FileInputStream InputStream = new FileInputStream(path);

        int oneByte = InputStream.read();
        while(oneByte != -1){
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = InputStream.read();
        }
    }
}
