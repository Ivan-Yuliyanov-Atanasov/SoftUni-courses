import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] token = scan.nextLine().split(" ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        String[][] matrix = new String[m][n];
        int counter = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = String.valueOf(counter);
                counter++;
            }
        }
        String input = "";
        while(!(input = scan.nextLine()).equals("Nuke it from orbit")){

            String [] tokens = input.split(" ");
            int rowIndex = Integer.parseInt(tokens[0]);
            int colIndex = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);
//            if((rowIndex < 0 || rowIndex >= matrix.length) || (colIndex < 0 || colIndex >= matrix[rowIndex].length)){
//                continue;
//            }

//            int startColIndex = Math.max(0,colIndex - radius);
//            int endColIndex = Math.min(colIndex + radius, matrix[rowIndex].length - 1);
//            for (int i = startColIndex; i <= endColIndex; i++) {
              for (int i = colIndex - radius; i <= colIndex + radius; i++) {
                try {
                    matrix[rowIndex][i] = "";
                } catch (Exception e){
                    continue;
                }

            }
//            int startRowIndex = Math.max(0,rowIndex - radius);
//            int endRowIndex = Math.min(rowIndex + radius, matrix.length - 1);
//            for (int i = startRowIndex; i <= endRowIndex; i++) {
              for (int i = rowIndex - radius; i <= rowIndex + radius; i++) {
                try {
                    matrix[i][colIndex] = "";
                } catch (Exception e){
                   continue;
                }


            }
            List<List<String>> helpList = new ArrayList<>();
            for (int row = 0; row < matrix.length; row++) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < matrix[row].length; i++) {
                    if (!matrix[row][i].equals("")) {
                        list.add(matrix[row][i]);
                    }

                }
                if(!list.isEmpty()){
                    helpList.add(list);
                }
//                String[] helpArr = new String[list.size()];
//
//                for (int i = 0; i < list.size(); i++) {
//                    helpArr[i] = list.get(i);
//
//                }
//                matrix[row] = helpArr;
            }
            String[][] helpMatrix = new String[helpList.size()][];
            for (int i = 0; i < helpList.size(); i++) {
                List<String> currentList = helpList.get(i);
                String[] helpArr = new String[currentList.size()];
                for (int j = 0; j < currentList.size(); j++) {
                    helpArr[j] = currentList.get(j);
                }
                helpMatrix[i] = helpArr;
            }
            matrix = helpMatrix;


        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
}
