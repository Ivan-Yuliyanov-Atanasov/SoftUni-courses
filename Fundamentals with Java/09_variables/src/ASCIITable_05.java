import java.util.Scanner;

public class ASCIITable_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        for (int i = num1; i <= num2 ; i++) {
            char character = (char) i;
            System.out.print(character + " ");

        }
    }
}
