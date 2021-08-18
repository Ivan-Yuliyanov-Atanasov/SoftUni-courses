import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] bannedWords = scan.nextLine().split(", ");
        String input = scan.nextLine();
        for (int i = 0; i < bannedWords.length; i++) {
            int n = bannedWords[i].length();
            String replaceWord = "";
            for (int j = 0; j < n; j++) {
                replaceWord += "*";

            }
            int index = input.indexOf(bannedWords[i]);
            while (index != -1){
                input = input.replace(bannedWords[i],replaceWord);
                index = input.indexOf(bannedWords[i]);
            }

        }
        System.out.println(input);
    }
}
