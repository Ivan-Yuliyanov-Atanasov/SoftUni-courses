import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] tokens = scan.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String command = tokens[1];
        int[][] matrix = new int[n][n];

        if("A".equals(command)){
            matrix = PatternA(n);
        } else {
            matrix = PatternB(n);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }

    private static int[][] PatternB(int n) {
        int counter = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = counter;
                    counter++;

                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[j][i] = counter;
                    counter++;

                }
            }


        }
        return matrix;
    }

    private static int[][] PatternA(int n) {
        int counter = 1;
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if(col == 0){
                    matrix[row][col] = counter;
                } else{
                    matrix[row][col] = counter + col * matrix.length;
                }
                if(col == matrix.length - 1){
                    counter++;
                }
            }
        }

        return matrix;
    }

}
