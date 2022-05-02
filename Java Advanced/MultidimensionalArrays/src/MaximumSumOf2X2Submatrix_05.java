import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] token = scan.nextLine().split(", ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m ; i++) {
            int [] input = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = 0;
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(sum > maxSum){
                    maxSum = sum;
                    maxMatrix[0][0] = matrix[row][col];
                    maxMatrix[0][1] = matrix[row][col + 1];
                    maxMatrix[1][0] = matrix[row + 1][col];
                    maxMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }

        }
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                System.out.print(maxMatrix[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
