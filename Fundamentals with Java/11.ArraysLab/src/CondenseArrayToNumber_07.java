import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = numbers.length;


        while (n > 1){
            int [] numToPrint = new int[n - 1];
            for (int i = 0; i < n-1; i++) {
                numToPrint[i] = numbers[i] + numbers[ i + 1];
                numbers[i] = numToPrint[i];

            }
            n --;


        }
        System.out.println(numbers[0]);

    }
}
