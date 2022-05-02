import java.util.Scanner;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[n][n];
        int mouseRow = 0;
        int mouseCol = 0;
        int eatenCheese = 0;
        boolean outOfBounds = false;
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            for (int j = 0; j < inputLine.length(); j++) {
                char currentCharacter = inputLine.charAt(j);
                if(currentCharacter == 'M'){
                    mouseRow = i;
                    mouseCol = j;
                }
            }
            matrix[i] = inputLine.toCharArray();
        }
        String command = "";
        while(!(command = scanner.nextLine()).equals("end")){
            switch (command){
                case "right":
                    if(inBounds(mouseRow,mouseCol + 1,matrix)){
                        if(matrix[mouseRow][mouseCol + 1] == 'c'){
                            eatenCheese++;
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol + 1] = 'M';
                            mouseCol++;

                        } else if(matrix[mouseRow][mouseCol + 1] == 'B'){
                            if(matrix[mouseRow][mouseCol + 2] == 'c'){
                                eatenCheese++;
                            }
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol + 1] = '-';
                            matrix[mouseRow][mouseCol + 2] = 'M';
                            mouseCol += 2;
                        } else {
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol + 1] = 'M';
                            mouseCol++;
                        }
                    } else {
                        outOfBounds = true;
                        matrix[mouseRow][mouseCol] = '-';
                    }
                    break;
                case "left":
                    if(inBounds(mouseRow,mouseCol - 1,matrix)){
                        if(matrix[mouseRow][mouseCol - 1] == 'c'){
                            eatenCheese++;
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol - 1] = 'M';
                            mouseCol--;

                        } else if(matrix[mouseRow][mouseCol - 1] == 'B'){
                            if(matrix[mouseRow][mouseCol - 2] == 'c'){
                                eatenCheese++;
                            }
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol - 1] = '-';
                            matrix[mouseRow][mouseCol - 2] = 'M';
                            mouseCol -= 2;
                        } else {
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow][mouseCol - 1] = 'M';
                            mouseCol--;
                        }
                    } else {
                        outOfBounds = true;
                        matrix[mouseRow][mouseCol] = '-';
                    }
                    break;
                case "down":
                    if(inBounds(mouseRow + 1,mouseCol,matrix)){
                        if(matrix[mouseRow + 1][mouseCol] == 'c'){
                            eatenCheese++;
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow + 1][mouseCol] = 'M';
                            mouseRow++;

                        } else if(matrix[mouseRow + 1][mouseCol] == 'B'){
                            if(matrix[mouseRow + 2][mouseCol] == 'c'){
                                eatenCheese++;
                            }
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow + 1][mouseCol] = '-';
                            matrix[mouseRow + 2][mouseCol] = 'M';
                            mouseRow += 2;
                        } else {
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow + 1][mouseCol] = 'M';
                            mouseRow++;
                        }
                    } else {
                        outOfBounds = true;
                        matrix[mouseRow][mouseCol] = '-';
                    }
                    break;
                case "up":
                    if(inBounds(mouseRow - 1,mouseCol,matrix)){
                        if(matrix[mouseRow - 1][mouseCol] == 'c'){
                            eatenCheese++;
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow - 1][mouseCol] = 'M';
                            mouseRow--;

                        } else if(matrix[mouseRow - 1][mouseCol] == 'B'){
                            if(matrix[mouseRow - 2][mouseCol] == 'c'){
                                eatenCheese++;
                            }
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow - 1][mouseCol] = '-';
                            matrix[mouseRow - 2][mouseCol] = 'M';
                            mouseRow -= 2;
                        } else {
                            matrix[mouseRow][mouseCol] = '-';
                            matrix[mouseRow - 1][mouseCol] = 'M';
                            mouseRow--;
                        }
                    } else {
                        outOfBounds = true;
                        matrix[mouseRow][mouseCol] = '-';
                    }
                    break;
            }
            if(outOfBounds){
                System.out.println("Where is the mouse?");
                break;
            }
        }
        if(eatenCheese < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
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
