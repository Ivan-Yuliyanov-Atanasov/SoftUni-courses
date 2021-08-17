import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        long factorial1 = getFactorial(num1);
        long factorial2 = getFactorial(num2);
        double division = (double) factorial1 / factorial2;
        System.out.printf("%.2f",division);
    }

    private static long getFactorial(int number) {
        long sum = 1;
        for (int i = 1; i <= number ; i++) {
            sum *= i;
        }
        return sum;
    }
}
