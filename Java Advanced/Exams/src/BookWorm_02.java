
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int n  = Integer.parseInt(reader.readLine());
        char [][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine();
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 'P'){
                    playerRow = i;
                    playerCol = j;
                }

            }
            matrix[i] = inputLine.toCharArray();

        }
        String command = "";
        while(!(command = reader.readLine()).equals("end")){
            switch (command){
                case "right":
                    if(inBounds(playerRow, playerCol + 1, matrix)){
                        matrix[playerRow][playerCol] = '-';
                        playerCol++;
                        if(matrix[playerRow][playerCol] != '-'){
                            word += matrix[playerRow][playerCol];
                        }
                        matrix[playerRow][playerCol] = 'P';

                    } else {
                        if(!word.isEmpty()){
                            word = word.substring(0,word.length() - 1);
                        }
                    }
                    break;
                case "left":
                    if(inBounds(playerRow, playerCol - 1, matrix)){
                        matrix[playerRow][playerCol] = '-';
                        playerCol--;
                        if(matrix[playerRow][playerCol] != '-'){
                            word += matrix[playerRow][playerCol];
                        }
                        matrix[playerRow][playerCol] = 'P';

                    } else {
                        if(!word.isEmpty()){
                            word = word.substring(0,word.length() - 1);
                        }
                    }
                    break;
                case "down":
                    if(inBounds(playerRow + 1, playerCol, matrix)){
                        matrix[playerRow][playerCol] = '-';
                        playerRow++;
                        if(matrix[playerRow][playerCol] != '-'){
                            word += matrix[playerRow][playerCol];
                        }
                        matrix[playerRow][playerCol] = 'P';

                    } else {
                        if(!word.isEmpty()){
                            word = word.substring(0,word.length() - 1);
                        }
                    }
                    break;
                case "up":
                    if(inBounds(playerRow - 1, playerCol, matrix)){
                        matrix[playerRow][playerCol] = '-';
                        playerRow--;
                        if(matrix[playerRow][playerCol] != '-'){
                            word += matrix[playerRow][playerCol];
                        }
                        matrix[playerRow][playerCol] = 'P';

                    } else {
                        if(!word.isEmpty()){
                            word = word.substring(0,word.length() - 1);
                        }
                    }
                    break;
            }

        }
        System.out.println(word);
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
