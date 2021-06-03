import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOdd_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int EvenSum = 0;
        int OddSum = 0;
        int [] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0){
                EvenSum += numbers[i];
            } else {
                OddSum += numbers[i];
            }

        }
        int diff = EvenSum - OddSum;
        System.out.println(diff);
    }
}
