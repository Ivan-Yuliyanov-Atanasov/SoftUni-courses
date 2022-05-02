import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
                elements.add(tokens[j]);


            }

        }
        for (String element : elements) {
            System.out.print(element + " ");

        }
    }
}
