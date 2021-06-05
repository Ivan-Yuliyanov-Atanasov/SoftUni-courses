import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine1 = scan.nextLine();
        String inputLine2 = scan.nextLine();
        String[] items1 = inputLine1.split(" ");
        String[] items2 = inputLine2.split(" ");
        for (int i = 0; i < items2.length; i++) {
            for (int j = 0; j < items1.length; j++) {
                if (items2[i].equals(items1[j])) {
                    System.out.print(items2[i] + " ");

                }
            }

        }
    }
}
