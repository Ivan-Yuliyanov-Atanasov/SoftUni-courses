import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wordToRemove = scan.nextLine();
        String input = scan.nextLine();
        int index = input.indexOf(wordToRemove);
        while (index != -1){
            input = input.replace(wordToRemove,"");
            index = input.indexOf(wordToRemove);
        }
        System.out.println(input);
    }
}
