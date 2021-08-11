import java.util.Scanner;

public class IntegerOperations_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());
        int n4 = Integer.parseInt(scan.nextLine());
        int sum = n1 + n2;
        sum = sum / n3;
        sum = sum * n4;
        System.out.println(sum);

    }
}
