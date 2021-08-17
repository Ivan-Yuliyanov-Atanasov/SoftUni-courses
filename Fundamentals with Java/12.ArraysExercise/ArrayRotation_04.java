import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        String[] items = inputLine.split(" ");
        int n = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < n; i++) {
            String[] firstCell = new String[1];
            firstCell[0] = items[0];
            for (int j = items.length; j>1 ; j--) {
                items[items.length - j] = items[items.length - j + 1];

            }
            items[items.length - 1] = firstCell[0];

        }

        for (String printItem : items) {
            System.out.print(printItem + " ");

        }

    }
}
