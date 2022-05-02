import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n ; i++) {
            int [] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }
        for (int i = 0; i < n; i++) {

            System.out.print(matrix[i][i] + " ");

        }
        System.out.println();
        for (int i = n - 1; i >= 0 ; i--) {

            System.out.print(matrix[i][n - i - 1] + " ");

        }
    }
}
