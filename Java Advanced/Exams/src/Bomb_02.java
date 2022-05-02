import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bomb_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(reader.readLine());
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        int bombCount = 0;
        String [] commands = reader.readLine().split(",");
        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine().replace(" ","");
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 's'){
                    playerRow = i;
                    playerCol = j;
                } else if(currentCharacter == 'B'){
                   bombCount++;
                }

            }
            matrix[i] = inputLine.toCharArray();

        }

        for (int i = 0; i < commands.length; i++) {
                String command = commands[i];
                switch (command){
                    case "right":
                        if(inBounds(playerRow, playerCol + 1,matrix)){
                            char currentSymbol = matrix[playerRow][playerCol + 1];
                            switch (currentSymbol){
                                case 'B':
                                    bombCount--;
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow][playerCol + 1] = 's';
                                    playerCol++;
                                    System.out.println("You found a bomb!");
                                    break;
                                case 'e':
                                    System.out.printf("END! %d bombs left on the field",bombCount);
                                    return;
                                default:
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow][playerCol + 1] = 's';
                                    playerCol++;
                                    break;
                            }

                        }else {
                            continue;
                        }
                        break;
                    case "up":
                        if(inBounds(playerRow - 1, playerCol,matrix)){
                            char currentSymbol = matrix[playerRow - 1][playerCol];
                            switch (currentSymbol){
                                case 'B':
                                    bombCount--;
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow - 1][playerCol] = 's';
                                    System.out.println("You found a bomb!");
                                    playerRow--;
                                    break;
                                case 'e':
                                    System.out.printf("END! %d bombs left on the field",bombCount);
                                    return;
                                default:
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow - 1][playerCol] = 's';
                                    playerRow--;
                                    break;
                            }

                        }else {
                            continue;
                        }
                        break;
                    case "left":
                        if(inBounds(playerRow, playerCol - 1,matrix)){
                            char currentSymbol = matrix[playerRow][playerCol - 1];
                            switch (currentSymbol){
                                case 'B':
                                    bombCount--;
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow][playerCol - 1] = 's';
                                    playerCol--;
                                    System.out.println("You found a bomb!");
                                    break;
                                case 'e':
                                    System.out.printf("END! %d bombs left on the field",bombCount);
                                    return;
                                default:
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow][playerCol - 1] = 's';
                                    playerCol--;
                                    break;
                            }

                        }else {
                            continue;
                        }
                        break;
                    case "down":
                        if(inBounds(playerRow + 1, playerCol,matrix)){
                            char currentSymbol = matrix[playerRow + 1][playerCol];
                            switch (currentSymbol){
                                case 'B':
                                    bombCount--;
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow + 1][playerCol] = 's';
                                    System.out.println("You found a bomb!");
                                    playerRow++;
                                    break;
                                case 'e':
                                    System.out.printf("END! %d bombs left on the field",bombCount);
                                    return;
                                default:
                                    matrix[playerRow][playerCol] = '+';
                                    matrix[playerRow + 1][playerCol] = 's';
                                    playerRow++;
                                    break;
                            }

                        }else {
                            continue;
                        }
                        break;
                }
                if(bombCount == 0){
                    break;
                }

        }
        if (bombCount == 0){
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombCount,playerRow,playerCol);
        }

    }

    private static boolean inBounds(int Row, int Col, char[][] matrix) {
        return ((Row >= 0 && Row < matrix.length) && (Col >= 0 && Col < matrix[Row].length));
    }
}
