import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> numberToPrint = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());
        if (n == 0){
            System.out.println(0);
            return;
        }
        while(n > 0){
            numberToPrint.push(n % 2);
            n /= 2;
        }
        for (Integer integer : numberToPrint) {
            System.out.print(integer);

        }
    }
}
