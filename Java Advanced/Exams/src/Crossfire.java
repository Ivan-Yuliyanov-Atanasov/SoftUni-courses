import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int rows = Integer.parseInt(inputLine.split(" ")[0]);
        int cols = Integer.parseInt(inputLine.split(" ")[1]);
        List<List<Integer>> matrix = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                currentRow.add(j, num);
                num++;

            }
            matrix.add(i, currentRow);
        }
        while (!(inputLine = scanner.nextLine()).equals("Nuke it from orbit")) {
            int bombRow = Integer.parseInt(inputLine.split(" ")[0]);
            int bombCol = Integer.parseInt(inputLine.split(" ")[1]);
            int radius = Integer.parseInt(inputLine.split(" ")[2]);

            for (int i = bombCol - radius; i <= bombCol + radius; i++) {
                if (bombRow >= 0 && bombRow < matrix.size()) {
                    if (i >= 0 && i < matrix.get(bombRow).size()) {
                        matrix.get(bombRow).set(i, 0);
                    }
                }
            }
            for (int i = bombRow - radius; i <= bombRow + radius; i++) {
                if (i >= 0 && i < matrix.size()) {
                    if (bombCol >= 0 && bombCol < matrix.get(i).size()) {
                        matrix.get(i).set(bombCol, 0);
                    }
                }
            }
            matrix.forEach(row -> row.removeIf(value -> value == 0));

            for (int i = 0; i < matrix.size(); i++) {
                if (matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                }
            }
        }
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
