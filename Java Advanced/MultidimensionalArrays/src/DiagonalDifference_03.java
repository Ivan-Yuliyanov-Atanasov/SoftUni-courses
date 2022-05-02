import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n ; i++) {
            int [] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {

            sum1 += matrix[i][i];

        }
        for (int i = n - 1; i >= 0 ; i--) {

            sum2 += matrix[i][n - i - 1];

        }
        System.out.println(Math.abs(sum1 - sum2));
    }
}
