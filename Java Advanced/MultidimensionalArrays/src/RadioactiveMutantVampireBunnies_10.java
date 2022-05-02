import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split(" ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        char[][] matrix = new char[m][n];
        int playerRow = 0;
        int playerCol = 0;
        ArrayDeque<Integer> bunnyPosition = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            String input = scan.nextLine();
            if(input.contains("P")){
                playerRow = i;
                playerCol = input.indexOf('P');
            }
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == 'B'){
                    bunnyPosition.offer(i);
                    bunnyPosition.offer(j);
                }

            }
            char [] arr = input.toCharArray();
            matrix[i] = arr;
        }
        List<Character> commands = new ArrayList<>();
        String inputLine = scan.nextLine();
        for (int i = 0; i < inputLine.length(); i++) {
            commands.add(inputLine.charAt(i));
        }
        boolean isEscaped = false;
        boolean isDead = false;
        for (int i = 0; i < commands.size(); i++) {
            int currentPlayerRow = playerRow;
            int currentPlayerCol = playerCol;
            char command = commands.get(i);
            switch (command){

                case 'U':
                    playerRow --;
                    if(!inBounds(playerRow, playerCol, matrix)){
                        isEscaped = true;
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                        playerRow++;
                    } else if (matrix[playerRow][playerCol] == 'B'){
                            isDead = true;

                    } else {
                        matrix[playerRow][playerCol] = 'P';
                        matrix[currentPlayerRow][currentPlayerCol] = '.';

                    }
                    break;
                case 'R':
                    playerCol ++;
                    if(!inBounds(playerRow, playerCol, matrix)){
                        isEscaped = true;
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                        playerCol--;
                    } else if(matrix[playerRow][playerCol] == 'B'){
                            isDead = true;

                    } else {
                        matrix[playerRow][playerCol] = 'P';
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                    }
                    break;
                case 'D':
                    playerRow ++;
                    if(!inBounds(playerRow, playerCol, matrix)){
                        isEscaped = true;
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                        playerRow--;
                    } else if(matrix[playerRow][playerCol] == 'B'){
                            isDead = true;

                    } else {
                        matrix[playerRow][playerCol] = 'P';
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                    }
                    break;
                case 'L':
                    playerCol --;
                    if(!inBounds(playerRow, playerCol, matrix)){
                        isEscaped = true;
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                        playerCol++;
                    } else if(matrix[playerRow][playerCol] == 'B'){
                            isDead = true;

                    } else {
                        matrix[playerRow][playerCol] = 'P';
                        matrix[currentPlayerRow][currentPlayerCol] = '.';
                    }
                    break;
            }
            int arrayDequeSize = bunnyPosition.size();
            for (int k = 0; k < arrayDequeSize / 2 ; k++) {
                int currentBunnyRow = bunnyPosition.poll();
                int currentBunnyCol = bunnyPosition.poll();


                        if(inBounds(currentBunnyRow - 1,currentBunnyCol,matrix)){
                            if(matrix[currentBunnyRow- 1][currentBunnyCol] == 'P'){
                                isDead = true;
                            }
                            matrix[currentBunnyRow - 1][currentBunnyCol] = 'B';
                        } if (inBounds(currentBunnyRow, currentBunnyCol + 1, matrix)){
                            if(matrix[currentBunnyRow][currentBunnyCol + 1] == 'P'){
                                isDead = true;
                            }
                            matrix[currentBunnyRow][currentBunnyCol + 1] = 'B';
                        }  if (inBounds(currentBunnyRow + 1, currentBunnyCol , matrix)){
                            if(matrix[currentBunnyRow + 1][currentBunnyCol] == 'P'){
                                isDead = true;
                            }
                            matrix[currentBunnyRow + 1][currentBunnyCol] = 'B';
                        }  if (inBounds(currentBunnyRow, currentBunnyCol - 1, matrix)){
                            if(matrix[currentBunnyRow][currentBunnyCol - 1] == 'P'){
                                isDead = true;
                            }
                            matrix[currentBunnyRow][currentBunnyCol - 1] = 'B';
                        }


            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {

                    if(matrix[row][col]== 'B'){
                        bunnyPosition.offer(row);
                        bunnyPosition.offer(col);
                    }
                }

            }
            if (isDead || isEscaped){
                break;
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }
       if(isDead){
           System.out.println("dead: " + playerRow + " " + playerCol);
       } else {
           System.out.println("won: " + playerRow + " " + playerCol);
       }


    }

    private static boolean inBounds(int Row, int Col, char[][] matrix) {
        return ((Row >= 0 && Row < matrix.length) && (Col >= 0 && Col < matrix[Row].length));
    }
}
