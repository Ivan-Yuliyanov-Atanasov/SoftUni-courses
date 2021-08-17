import java.util.Scanner;

public class NxN_Matrix_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            printLine(n);

        }
    }

    private static void printLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");

        }
        System.out.println();
    }
}
