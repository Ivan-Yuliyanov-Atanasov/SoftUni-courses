import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] tokens = scan.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String [][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split(" ");
        }
        int row = rows - 1;
        int col = cols - 1;
        while (row >= 0){
            int currentRow = row;
            int currentCol = col;
            while (currentCol < cols && currentRow >= 0){
                System.out.print(matrix[currentRow--][currentCol++] + " ");
            }
            System.out.println();
            col--;
            if(col < 0){
                col = 0;
                row--;
            }

        }
    }
}
