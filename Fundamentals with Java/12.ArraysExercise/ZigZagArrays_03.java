import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] items1 = new int[n];
        int[] items2 = new int[n];
        for (int i = 0; i < n; i++) {
            int[] number = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            if (i % 2 == 0) {
                items1[i] = number[0];
                items2[i] = number[1];

            } else {
                items1[i] = number[1];
                items2[i] = number[0];
            }
        }
            for (int num1 : items1) {
                System.out.print(num1 + " ");

            }
            System.out.println();
            for (int num2 : items2) {
                System.out.print(num2 + " ");

            }

    }
}
