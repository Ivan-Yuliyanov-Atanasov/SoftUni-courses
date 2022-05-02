import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] token = scan.nextLine().split(" ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m ; i++) {
            String [] input = scan.nextLine().split(" ");
            matrix[i] = input;
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("END")){
            String [] tokens = input.split(" ");
            if(!tokens[0].equals("swap") || tokens.length != 5){
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                if(!isValid(m, n, row1, col1, row2, col2)){
                    System.out.println("Invalid input!");
                } else {
                    String c = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = c;
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            System.out.print(matrix[i][j] + " ");

                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    private static boolean isValid(int m, int n, int row1, int col1, int row2, int col2) {
        if((row1 >= 0 && row1 < m) && (row2 >= 0 && row2 < m) && (col1 >= 0 && col1 < n) && (col2 >= 0 && col2 < n)){
            return true;
        }
        return false;
    }


}
