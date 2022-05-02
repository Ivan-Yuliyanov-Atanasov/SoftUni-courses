import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int pollinatedFlowers = 0;
        boolean outOfBounds = false;
        char[][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;


        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine().replace(" ", "");
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if (currentCharacter == 'B') {
                    playerRow = i;
                    playerCol = j;

                }

            }
            matrix[i] = inputLine.toCharArray();
        }
            String command = reader.readLine();
            while(!command.equals("End")){
                switch (command){
                    case "right":
                        if(inBounds(playerRow,playerCol + 1,matrix)){
                            char currentSymbol = matrix[playerRow][playerCol + 1];
                            if(currentSymbol == 'f'){
                                pollinatedFlowers++;
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol + 1] = 'B';
                                playerCol++;
                            } else if (currentSymbol == 'O'){
                                if(matrix[playerRow][playerCol + 2] == 'f'){
                                    pollinatedFlowers++;
                                }
                                matrix[playerRow][playerCol + 1] = '.';
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol + 2] = 'B';
                                playerCol += 2;


                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol + 1] = 'B';
                                playerCol++;
                            }
                        } else {
                            outOfBounds = true;
                            matrix[playerRow][playerCol] = '.';
                    }
                        break;
                    case "left":
                        if(inBounds(playerRow,playerCol - 1,matrix)){
                            char currentSymbol = matrix[playerRow][playerCol - 1];
                            if(currentSymbol == 'f'){
                                pollinatedFlowers++;
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol - 1] = 'B';
                                playerCol--;
                            } else if (currentSymbol == 'O'){
                                if(matrix[playerRow][playerCol - 2] == 'f'){
                                    pollinatedFlowers++;
                                }
                                matrix[playerRow][playerCol - 1] = '.';
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol - 2] = 'B';
                                playerCol -= 2;


                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow][playerCol - 1] = 'B';
                                playerCol--;
                            }
                        } else {
                            outOfBounds = true;
                            matrix[playerRow][playerCol] = '.';
                        }
                        break;
                    case "up":
                        if(inBounds(playerRow - 1,playerCol,matrix)){
                            char currentSymbol = matrix[playerRow - 1][playerCol];
                            if(currentSymbol == 'f'){
                                pollinatedFlowers++;
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow - 1][playerCol] = 'B';
                                playerRow--;
                            } else if (currentSymbol == 'O'){
                                if(matrix[playerRow - 2][playerCol] == 'f'){
                                    pollinatedFlowers++;
                                }
                                matrix[playerRow - 1][playerCol] = '.';
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow - 2][playerCol] = 'B';
                                playerRow -= 2;


                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow - 1][playerCol] = 'B';
                                playerRow--;
                            }
                        } else {
                            outOfBounds = true;
                            matrix[playerRow][playerCol] = '.';
                        }
                        break;
                    case "down":
                        if(inBounds(playerRow + 1,playerCol,matrix)){
                            char currentSymbol = matrix[playerRow + 1][playerCol];
                            if(currentSymbol == 'f'){
                                pollinatedFlowers++;
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow + 1][playerCol] = 'B';
                                playerRow++;
                            } else if (currentSymbol == 'O'){
                                if(matrix[playerRow + 2][playerCol] == 'f'){
                                    pollinatedFlowers++;
                                }
                                matrix[playerRow + 1][playerCol] = '.';
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow + 2][playerCol] = 'B';
                                playerRow += 2;


                            } else {
                                matrix[playerRow][playerCol] = '.';
                                matrix[playerRow + 1][playerCol] = 'B';
                                playerRow++;
                            }
                        } else {
                            outOfBounds = true;
                            matrix[playerRow][playerCol] = '.';
                        }
                        break;
                }
                if(outOfBounds){
                    break;
                }
                command = reader.readLine();
            }
        if(outOfBounds){
            System.out.println("The bee got lost!");
        }
        if(pollinatedFlowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers);
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
