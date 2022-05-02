import java.util.Scanner;

public class IntersectionofTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        String [][] firstMatrix = readMatrix(scan,m,n);
        String [][] secondMatrix = readMatrix(scan,m,n);
        String [][] resultMatrix = new String[m][n];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if(firstMatrix[row][col].equals(secondMatrix[row][col])){
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }

            }
        }
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scan, int row, int col) {
        String [][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String symbol = scan.next();
                matrix[i][j] = symbol;

            }
        }
        return matrix;
    }
}
