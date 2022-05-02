import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        int numberOfCommands  = Integer.parseInt(scanner.nextLine());
        boolean win = false;
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 'P'){
                    playerRow = i;
                    playerCol = j;
                }
            }
            matrix[i] = inputLine.toCharArray();
        }
        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();
            switch (command){
                case "right":
                    if(inBounds(playerRow, playerCol + 1, matrix)){
                        if(matrix[playerRow][playerCol + 1] == 'F'){
                            matrix[playerRow][playerCol + 1] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            win = true;

                        } else if (matrix[playerRow][playerCol + 1] == '.'){
                            matrix[playerRow][playerCol + 1] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            playerCol++;
                        } else if (matrix[playerRow][playerCol + 1] == 'B'){
                            if(inBounds(playerRow,playerCol + 2,matrix)){
                                if(matrix[playerRow][playerCol + 2] == 'F'){
                                    matrix[playerRow][playerCol + 2] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    win = true;
                                } else {
                                    matrix[playerRow][playerCol + 2] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    playerCol += 2;
                                }

                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][0] = 'P';
                                playerCol = 0;
                            }
                        } else if (matrix[playerRow][playerCol + 1] == 'T'){
                            continue;
                        }

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][0] = 'P';
                        playerCol = 0;
                    }
                    break;
                case "left":
                    if(inBounds(playerRow, playerCol - 1, matrix)){
                        if(matrix[playerRow][playerCol - 1] == 'F'){
                            matrix[playerRow][playerCol - 1] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            win = true;

                        } else if (matrix[playerRow][playerCol - 1] == '.'){
                            matrix[playerRow][playerCol - 1] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            playerCol--;
                        } else if (matrix[playerRow][playerCol - 1] == 'B'){
                            if(inBounds(playerRow,playerCol - 2,matrix)){
                                if(matrix[playerRow][playerCol - 2] == 'F'){
                                    matrix[playerRow][playerCol - 2] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    win = true;
                                } else {
                                    matrix[playerRow][playerCol - 2] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    playerCol -= 2;
                                }

                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][n - 1] = 'P';
                                playerCol = n - 1;
                            }
                        } else if (matrix[playerRow][playerCol - 1] == 'T'){
                            continue;

                        }

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][n - 1] = 'P';
                        playerCol = n - 1;
                    }
                    break;
                case "up":
                    if(inBounds(playerRow - 1, playerCol, matrix)){
                        if(matrix[playerRow - 1][playerCol] == 'F'){
                            matrix[playerRow - 1][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            win = true;

                        } else if (matrix[playerRow - 1][playerCol] == '.'){
                            matrix[playerRow - 1][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            playerRow--;
                        } else if (matrix[playerRow - 1][playerCol] == 'B'){
                            if(inBounds(playerRow - 2,playerCol,matrix)){
                                if(matrix[playerRow - 2][playerCol] == 'F'){
                                    matrix[playerRow - 2][playerCol] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    win = true;
                                } else {
                                    matrix[playerRow - 2][playerCol] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    playerRow -= 2;
                                }

                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[n - 1][playerCol] = 'P';
                                playerRow = n - 1;
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'T'){
                            continue;
                        }

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        matrix[n - 1][playerCol] = 'P';
                        playerRow = n - 1;
                    }
                    break;
                case "down":
                    if(inBounds(playerRow + 1, playerCol, matrix)){
                        if(matrix[playerRow + 1][playerCol] == 'F'){
                            matrix[playerRow + 1][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            win = true;

                        } else if (matrix[playerRow + 1][playerCol] == '.'){
                            matrix[playerRow + 1][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '.';
                            playerRow++;
                        } else if (matrix[playerRow + 1][playerCol] == 'B'){
                            if(inBounds(playerRow + 2,playerCol,matrix)){
                                if( matrix[playerRow + 2][playerCol] == 'F'){
                                    matrix[playerRow + 2][playerCol] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    win = true;
                                } else {
                                    matrix[playerRow + 2][playerCol] = 'P';
                                    matrix[playerRow][playerCol] = '.';
                                    playerRow += 2;
                                }

                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[0][playerCol] = 'P';
                                playerRow = 0;
                            }
                        } else if (matrix[playerRow + 1][playerCol] == 'T'){
                            continue;

                        }

                    } else {
                        matrix[playerRow][playerCol] = '.';
                        matrix[0][playerCol] = 'P';
                        playerRow = 0;
                    }
                    break;
            }
            if(win){
                break;
            }

        }
        if(win){
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }

    }
    private static boolean inBounds(int Row, int Col, char[][] matrix) {
        return ((Row >= 0 && Row < matrix.length) && (Col >= 0 && Col < matrix[Row].length));
    }
}
