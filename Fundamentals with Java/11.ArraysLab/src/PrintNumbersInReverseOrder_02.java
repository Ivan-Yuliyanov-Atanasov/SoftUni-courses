import java.util.Scanner;

public class PrintNumbersInReverseOrder_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Integer [] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            numbers[i] = num;

        }
        for (int i = numbers.length - 1; i >=0 ; i--) {
            System.out.print(numbers[i] + " ");

        }

    }
}
