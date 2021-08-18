import java.util.Scanner;

public class RepeatStrings02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] words = scan.nextLine().split("\\s+");
        StringBuilder toPrint = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            for (int j = 0; j < n; j++) {
                toPrint.append(words[i]);

            }

        }
        System.out.println(toPrint.toString());

    }
}
