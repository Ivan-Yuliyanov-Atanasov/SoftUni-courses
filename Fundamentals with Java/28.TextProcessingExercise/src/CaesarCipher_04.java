import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder toPrint = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int n = (int) input.charAt(i) + 3;
            toPrint.append((char)n);

        }
        System.out.println(toPrint.toString());
    }
}
