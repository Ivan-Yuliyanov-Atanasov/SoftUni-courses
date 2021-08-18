import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split("\\\\");
        String file = input[input.length - 1];
        int index = file.indexOf(".");
        String fileName = file.substring(0,index);
        String format = file.substring(index + 1);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + format);

    }
}
