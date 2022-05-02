import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] tokens = scan.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String word = "";
                char firstLetter = (char)('a' + row);
                char secondLetter = (char)('a' + col + row);
                char thirdLetter = (char)('a' + row);
                word = String.valueOf(firstLetter) + secondLetter + thirdLetter;
                matrix[row][col] = word;

            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }
}
