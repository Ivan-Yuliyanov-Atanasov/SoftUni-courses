import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int sum = sum(num1, num2);
        System.out.println(subtract(sum, num3));

    }
    private static int sum (int a, int b){
        int sum = a + b;
        return sum;
    }
    private static int subtract(int a, int b){
        int division = a - b;
        return division;
    }
}
