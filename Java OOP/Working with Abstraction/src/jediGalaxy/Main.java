package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = dimensions[0];
            int y = dimensions[1];

            int[][] matrix = new int[x][y];

        fillMatrix(x, y, matrix);


        String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] playerCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int evilRow = evilCoordinates[0];
                int evilCol = evilCoordinates[1];

                while (evilRow >= 0 && evilCol >= 0)
                {
                    if (inBounds(matrix, evilRow, evilCol))
                    {
                        matrix[evilRow] [evilCol] = 0;
                    }
                    evilRow--;
                    evilCol--;
                }

                int playerRow = playerCoordinates[0];
                int playerCol = playerCoordinates[1];

                while (playerRow >= 0 && playerCol < matrix[1].length)
                {
                    if (inBounds(matrix, playerRow, playerCol))
                    {
                        sum += matrix[playerRow][playerCol];
                    }

                    playerCol++;
                    playerRow--;
                }

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static boolean inBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }
    }
}
