import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         int [] numbers = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(e -> Integer.parseInt(e)).toArray();
         int sum = 0;
         int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0){
                sum += numbers[i];
            }

        }
        System.out.println(sum);
    }
}
