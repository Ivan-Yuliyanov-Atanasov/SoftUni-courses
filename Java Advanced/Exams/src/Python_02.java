import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(", ");
        int foodCount = 0;
        int snakeLength = 1;
        boolean killedByEnemy = false;
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine().replace(" ","");
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 's'){
                    playerRow = i;
                    playerCol = j;
                } else if(currentCharacter == 'f'){
                    foodCount++;
                }
            }
            matrix[i] = inputLine.toCharArray();
        }
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand){
                case "right":
                    if(inBounds(playerRow,playerCol + 1,matrix)){
                        char currentSymbol = matrix[playerRow][playerCol + 1];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow][playerCol + 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol++;
                                break;
                            default:
                                matrix[playerRow][playerCol + 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol++;
                                break;

                        }
                    } else {
                        char currentSymbol = matrix[playerRow][0];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow][0] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol = 0;
                                break;
                            default:
                                matrix[playerRow][0] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol = 0;
                                break;

                        }

                    }
                    break;
                case "up":
                    if(inBounds(playerRow - 1,playerCol,matrix)){
                        char currentSymbol = matrix[playerRow - 1][playerCol];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow - 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow--;
                                break;
                            default:
                                matrix[playerRow - 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow--;
                                break;

                        }
                    } else {
                        char currentSymbol = matrix[n - 1][playerCol];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[n - 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow = n - 1;
                                break;
                            default:
                                matrix[n - 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow = n - 1;
                                break;

                        }

                    }
                    break;
                case "down":
                    if(inBounds(playerRow + 1,playerCol,matrix)){
                        char currentSymbol = matrix[playerRow + 1][playerCol];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow + 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow++;
                                break;
                            default:
                                matrix[playerRow + 1][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow++;
                                break;

                        }
                    } else {
                        char currentSymbol = matrix[0][playerCol];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[0][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow = 0;
                                break;
                            default:
                                matrix[0][playerCol] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerRow = 0;
                                break;

                        }

                    }
                    break;
                case "left":
                    if(inBounds(playerRow,playerCol - 1,matrix)){
                        char currentSymbol = matrix[playerRow][playerCol - 1];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow][playerCol - 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol--;
                                break;
                            default:
                                matrix[playerRow][playerCol - 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol--;
                                break;

                        }
                    } else {
                        char currentSymbol = matrix[playerRow][n - 1];
                        switch (currentSymbol){
                            case 'e':
                                killedByEnemy = true;
                                break;
                            case 'f':
                                foodCount--;
                                snakeLength++;
                                matrix[playerRow][n - 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol = n - 1;
                                break;
                            default:
                                matrix[playerRow][n - 1] = 's';
                                matrix[playerRow][playerCol] = '*';
                                playerCol = n - 1;
                                break;

                        }

                    }
                    break;

            }


            if(killedByEnemy){
                break;
            }
            if(foodCount == 0){
                break;
            }

        }
        if(killedByEnemy){
            System.out.print("You lose! Killed by an enemy!");
        } else {
            if(foodCount == 0){
                System.out.printf("You win! Final python length is %d",snakeLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.",foodCount);
            }
        }
    }
    private static boolean inBounds(int Row, int Col, char[][] matrix) {
        return ((Row >= 0 && Row < matrix.length) && (Col >= 0 && Col < matrix[Row].length));
    }
}
