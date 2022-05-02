import java.util.Scanner;

public class ParkingSystem_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split(" ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        int[][] matrix = new int[m][n];
        String input = "";
        while (!(input = scan.nextLine()).equals("stop")) {
            int moves = 1;

            boolean findPlace = false;
            String[] tokens = input.split(" ");
            int z = Integer.parseInt(tokens[0]);
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);
            if (z != x) {
                moves += Math.abs(x - z);
            }
            if (matrix[x][y] == 0) {
                matrix[x][y] = 1;
                findPlace = true;
                moves += y;
            } else {
                int indexBack = 0;
                int indexFront = 0;
                
                for (int i = y - 1; i >= 1 ; i--) {
                    if(matrix[x][i] == 0){
                        indexBack = i;
                        break;
                    }
                    
                }
                for (int i = y + 1; i < matrix[x].length; i++) {
                    if(matrix[x][i] == 0){
                        indexFront = i;
                        break;
                    }
                    
                }
                if(indexBack == 0 && indexFront == 0){
                    System.out.println("Row " + x + " full");

                } else {
                    if(indexBack == 0){
                        matrix[x][indexFront] = 1;
                        moves += indexFront;
                        findPlace = true;
                    } else if (indexFront == 0){
                        matrix[x][indexBack] = 1;
                        moves += indexBack;
                        findPlace = true;
                    } else {
                        if(y - indexBack > indexFront - y){
                            matrix[x][indexFront] = 1;
                            moves += indexFront;

                        } else {
                            matrix[x][indexBack] = 1;
                            moves += indexBack;

                        }
                        findPlace = true;
                    }

                }

            }


            if (findPlace) {
                System.out.println(moves);
            }
        }
       
    }
}
    