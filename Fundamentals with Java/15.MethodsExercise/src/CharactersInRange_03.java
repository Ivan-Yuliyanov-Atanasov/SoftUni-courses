import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String symbol1 = scan.nextLine();
        String symbol2 = scan.nextLine();

        int n1 = (int) symbol1.charAt(0);
        int n2 = (int) symbol2.charAt(0);
        if (n1 > n2) {
            printAllCharactersInRange1(n1, n2);
        } else if (n1 < n2) {
            printAllCharactersInRange(n1, n2);
        }

    }

    private static void printAllCharactersInRange1(int n1, int n2) {
        for (int i = n2 + 1; i < n1 ; i++) {
            System.out.print((char) i + " ");

        }
    }

    private static void printAllCharactersInRange(int n1, int n2) {
        for (int i = n1 + 1; i < n2 ; i++) {
            System.out.print((char) i + " ");

        }
    }
}
