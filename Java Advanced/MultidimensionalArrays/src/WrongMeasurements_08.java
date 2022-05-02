import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][];
        int[][] matrixToPrint = new int[n][];
        for (int i = 0; i < n ; i++) {
            int [] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
            matrixToPrint[i] = new int[matrix[i].length];

        }
        String [] indexes = scan.nextLine().split(" ");
        int rowIndex = Integer.parseInt(indexes[0]);
        int colIndex = Integer.parseInt(indexes[1]);
        int wrongNumber = matrix[rowIndex][colIndex];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == wrongNumber){
                    int sum = 0;
                    if(col - 1 >= 0 && matrix[row][col - 1] != wrongNumber){
                        sum += matrix[row][col - 1];
                    }
                    if(col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber){
                        sum += matrix[row][col + 1];
                    }
                    if(row - 1 >= 0  && matrix[row - 1][col] != wrongNumber){
                        sum += matrix[row - 1][col];
                    }
                    if(row + 1 < matrix.length  && matrix[row + 1][col] != wrongNumber){
                        sum += matrix[row + 1][col];
                    }
                    if(sum != 0){
                        matrixToPrint[row][col] = sum;
                    }
                } else {
                    matrixToPrint[row][col] = matrix[row][col];
                }
            }
        }
        for (int i = 0; i < matrixToPrint.length; i++) {
            for (int j = 0; j < matrixToPrint[i].length; j++) {
                System.out.print(matrixToPrint[i][j] + " ");

            }
            System.out.println();
        }
    }
}
