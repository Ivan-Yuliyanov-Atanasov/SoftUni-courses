import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 1; i <=n  ; i++) {
            String input = scan.nextLine();
            char letter = input.charAt(0);
            sum += (int) letter;

        }
        System.out.printf("The sum equals: %d",sum);
    }
}