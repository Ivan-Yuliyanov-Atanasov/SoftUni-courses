import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String rotation = scan.nextLine();
        int rotationAngle = Integer.parseInt(rotation.substring(7,rotation.length() - 1));

        String input = "";
        while(!(input= scan.nextLine()).equals("END")){

            words.add(input);
        }
        int maxLetterCount = 0;
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).length() > maxLetterCount){
                maxLetterCount = words.get(i).length();
            }
        }
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).length() < maxLetterCount){
                int diff = maxLetterCount - words.get(i).length();
                String currentWord = words.get(i);
                for (int j = 0; j < diff; j++) {
                    currentWord += " ";
                }
                words.set(i,currentWord);
            }

        }
        char [][] text = new char[words.size()][];
        for (int row = 0; row < text.length; row++) {
            char[] word = words.get(row).toCharArray();
            text[row] = word;

        }
        char [][] text90Degrees = new char[maxLetterCount][words.size()];
        for (int col = 0; col < words.size(); col++) {
            for (int row = 0; row < maxLetterCount; row++) {
                String word = words.get(words.size() - col - 1);
                text90Degrees[row][col] = word.charAt(row);
            }
        }
        char [][] text180Degrees = new char[words.size()][maxLetterCount];
        for (int row = 0; row < words.size(); row++) {
            for (int col = 0; col < maxLetterCount; col++) {
                String word = words.get(words.size() - row - 1);
                text180Degrees[row][col] = word.charAt(maxLetterCount - col - 1);
            }
        }
        char [][] text270Degrees = new char[maxLetterCount][words.size()];
        for (int col = 0; col < words.size(); col++) {
            for (int row = 0; row < maxLetterCount; row++) {
                String word = words.get(col);
                text270Degrees[row][col] = word.charAt(maxLetterCount - row - 1);
            }
        }
        int pointer = (rotationAngle / 90) % 4;
        if(pointer == 1){
            printMatrix(text90Degrees);
        } else if ( pointer == 2){
            printMatrix(text180Degrees);
        } else if (pointer == 3){
            printMatrix(text270Degrees);
        } else {
            printMatrix(text);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }

    }
}
