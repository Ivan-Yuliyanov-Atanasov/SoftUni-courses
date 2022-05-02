import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\SoftUni\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scan = new Scanner(reader);
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                System.out.println(scan.nextInt());
            }
            scan.next();
        }
    }
}
