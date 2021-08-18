import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger number1 = new BigInteger(scan.nextLine());
        BigInteger number2 = new BigInteger(scan.nextLine());
        System.out.println(number1.add(number2));
    }
}
