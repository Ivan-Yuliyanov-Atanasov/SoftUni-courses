import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookingJourney_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(reader.readLine());
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        int firstPillarRow = -1;
        int firstPillarCol = -1;
        int secondPillarRow = -1;
        int secondPillarCol = -1;
        boolean firstPillarMark = true;
        boolean outOfBounds = false;
        int money = 0;
        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine();
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 'S'){
                    playerRow = i;
                    playerCol = j;
                } else if(currentCharacter == 'P'){
                    if(firstPillarMark){
                        firstPillarRow = i;
                        firstPillarCol = j;
                        firstPillarMark = false;
                    } else {
                        secondPillarRow = i;
                        secondPillarCol = j;
                    }
                }

            }
            matrix[i] = inputLine.toCharArray();

        }

        while (money < 50 && !outOfBounds){
            String command = reader.readLine();
            switch (command){
                case "right":
                    if(inBounds(playerRow,playerCol + 1,matrix)){
                        char currentSymbol = matrix[playerRow][playerCol + 1];
                        if(Character.isDigit(currentSymbol)){
                            money += Character.getNumericValue(currentSymbol);
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'S';
                            playerCol++;
                        } else if (currentSymbol == 'P'){
                            matrix[playerRow][playerCol] = '-';
                            if(playerCol + 1 == firstPillarCol){
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow][playerCol + 1] = '-';
                                playerRow = secondPillarRow;
                                playerCol = secondPillarCol;
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow][playerCol + 1] = '-';
                                playerRow = firstPillarRow;
                                playerCol = firstPillarCol;
                            }
                        } else {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'S';
                            playerCol++;
                        }

                    } else {
                        outOfBounds = true;
                        matrix[playerRow][playerCol] = '-';
                    }
                    break;
                case "left":
                    if(inBounds(playerRow,playerCol - 1,matrix)){
                        char currentSymbol = matrix[playerRow][playerCol - 1];
                        if(Character.isDigit(currentSymbol)){
                            money += Character.getNumericValue(currentSymbol);
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'S';
                            playerCol--;
                        } else if (currentSymbol == 'P'){
                            matrix[playerRow][playerCol] = '-';
                            if(playerCol - 1 == firstPillarCol){
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow][playerCol - 1] = '-';
                                playerRow = secondPillarRow;
                                playerCol = secondPillarCol;
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow][playerCol - 1] = '-';
                                playerRow = firstPillarRow;
                                playerCol = firstPillarCol;
                            }
                        } else {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'S';
                            playerCol--;
                        }

                    } else {
                        outOfBounds = true;
                        matrix[playerRow][playerCol] = '-';
                    }
                    break;
                case "up":
                    if(inBounds(playerRow - 1,playerCol,matrix)){
                        char currentSymbol = matrix[playerRow - 1][playerCol];
                        if(Character.isDigit(currentSymbol)){
                            money += Character.getNumericValue(currentSymbol);
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'S';
                            playerRow--;
                        } else if (currentSymbol == 'P'){
                            matrix[playerRow][playerCol] = '-';
                            if(playerRow - 1 == firstPillarRow){
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow - 1][playerCol] = '-';
                                playerRow = secondPillarRow;
                                playerCol = secondPillarCol;
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow - 1][playerCol] = '-';
                                playerRow = firstPillarRow;
                                playerCol = firstPillarCol;
                            }
                        } else {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'S';
                            playerRow--;
                        }

                    } else {
                        outOfBounds = true;
                        matrix[playerRow][playerCol] = '-';
                    }
                    break;
                case "down":
                    if(inBounds(playerRow + 1,playerCol,matrix)){
                        char currentSymbol = matrix[playerRow + 1][playerCol];
                        if(Character.isDigit(currentSymbol)){
                            money += Character.getNumericValue(currentSymbol);
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'S';
                            playerRow++;
                        } else if (currentSymbol == 'P'){
                            matrix[playerRow][playerCol] = '-';
                            if(playerRow + 1 == firstPillarRow){
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow + 1][playerCol] = '-';
                                playerRow = secondPillarRow;
                                playerCol = secondPillarCol;
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                matrix[playerRow + 1][playerCol] = '-';
                                playerRow = firstPillarRow;
                                playerCol = firstPillarCol;
                            }
                        } else {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'S';
                            playerRow++;
                        }

                    } else {
                        outOfBounds = true;
                        matrix[playerRow][playerCol] = '-';
                    }
                    break;
            }


        }
        if(outOfBounds) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",money);
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
