import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresentDelivery_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int presentsCount = Integer.parseInt(reader.readLine());
        int n  = Integer.parseInt(reader.readLine());
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        boolean outOfBounds = false;
        int niceKidsTotal = 0;
        int niceKidsReceivedPresent = 0;

        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine().replace(" ","");
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 'S'){
                    playerRow = i;
                    playerCol = j;
                } else if (currentCharacter == 'V'){
                    niceKidsTotal++;
                }

            }
            matrix[i] = inputLine.toCharArray();

        }

        String command = reader.readLine();
        while (presentsCount > 0 && !command.equals("Christmas morning")){
            switch (command){
                case "left":
                    if(inBounds(playerRow,playerCol - 1,matrix)) {
                        char currentSymbol = matrix[playerRow][playerCol - 1];
                        if(currentSymbol == 'V'){
                            niceKidsReceivedPresent++;
                            presentsCount--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'S';
                            playerCol--;
                        } else if(currentSymbol == 'X' || currentSymbol == '-'){
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'S';
                            playerCol--;
                        } else if(currentSymbol == 'C'){
                            hitCookie(playerRow,playerCol,matrix,presentsCount,niceKidsReceivedPresent);
                        }
                    } else {
                        outOfBounds = true;
                    }
                    break;
                case "right":
                    if(inBounds(playerRow,playerCol + 1,matrix)) {
                        char currentSymbol = matrix[playerRow][playerCol + 1];
                        if(currentSymbol == 'V'){
                            niceKidsReceivedPresent++;
                            presentsCount--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'S';
                            playerCol++;
                        } else if(currentSymbol == 'X' || currentSymbol == '-'){
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'S';
                            playerCol++;
                        } else if(currentSymbol == 'C'){
                            hitCookie(playerRow,playerCol,matrix,presentsCount,niceKidsReceivedPresent);
                        }
                    } else {
                        outOfBounds = true;
                    }
                    break;
                case "up":
                    if(inBounds(playerRow - 1,playerCol,matrix)) {
                        char currentSymbol = matrix[playerRow - 1][playerCol];
                        if(currentSymbol == 'V'){
                            niceKidsReceivedPresent++;
                            presentsCount--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'S';
                            playerRow--;
                        } else if(currentSymbol == 'X' || currentSymbol == '-'){
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'S';
                            playerRow--;
                        } else if(currentSymbol == 'C'){
                            hitCookie(playerRow,playerCol,matrix,presentsCount,niceKidsReceivedPresent);
                        }
                    } else {
                        outOfBounds = true;
                    }
                    break;
                case "down":
                    if(inBounds(playerRow + 1,playerCol,matrix)) {
                        char currentSymbol = matrix[playerRow + 1][playerCol];
                        if(currentSymbol == 'V'){
                            niceKidsReceivedPresent++;
                            presentsCount--;
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'S';
                            playerRow++;
                        } else if(currentSymbol == 'X' || currentSymbol == '-'){
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'S';
                            playerRow++;
                        } else if(currentSymbol == 'C'){
                            hitCookie(playerRow,playerCol,matrix,presentsCount,niceKidsReceivedPresent);
                        }
                    } else {
                        outOfBounds = true;
                    }
                    break;
            }

            if(outOfBounds || presentsCount == 0){
                break;
            }
            command = reader.readLine();
        }

        if((outOfBounds || presentsCount == 0)){
            System.out.println("Santa ran out of presents!");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        if(niceKidsTotal == niceKidsReceivedPresent){
            System.out.printf("Good job, Santa! %d happy nice kid/s.",niceKidsTotal);
        } else {
            System.out.printf("No presents for %d nice kid/s.",niceKidsTotal - niceKidsReceivedPresent);
        }


    }
    private static boolean inBounds(int Row, int Col, char[][] matrix) {
        return ((Row >= 0 && Row < matrix.length) && (Col >= 0 && Col < matrix[Row].length));
    }
    public static void hitCookie(int playerRow, int playerCol, char[][] matrix, int presentsCount, int niceKidsReceivedPresent){
        if(matrix[playerRow - 1][playerCol] == 'V' || matrix[playerRow - 1][playerCol] == 'X'){
            matrix[playerRow - 1][playerCol] = '-';
            presentsCount--;
            if(matrix[playerRow - 1][playerCol] == 'V'){
                niceKidsReceivedPresent++;
            }
            if(matrix[playerRow][playerCol + 1] == 'V' || matrix[playerRow][playerCol - 1] == 'X'){
                matrix[playerRow][playerCol + 1] = '-';
                presentsCount--;
                if(matrix[playerRow][playerCol + 1] == 'V'){
                    niceKidsReceivedPresent++;
                }
            }
            if(matrix[playerRow + 1][playerCol] == 'V' || matrix[playerRow + 1][playerCol] == 'X') {
                matrix[playerRow + 1][playerCol] = '-';
                presentsCount--;
                if (matrix[playerRow + 1][playerCol] == 'V') {
                    niceKidsReceivedPresent++;
                }
            }
            if(matrix[playerRow][playerCol - 1] == 'V' || matrix[playerRow][playerCol - 1] == 'X') {
                matrix[playerRow][playerCol - 1] = '-';
                presentsCount--;
                if (matrix[playerRow][playerCol - 1] == 'V') {
                    niceKidsReceivedPresent++;
                }
            }
        }
    }

}
