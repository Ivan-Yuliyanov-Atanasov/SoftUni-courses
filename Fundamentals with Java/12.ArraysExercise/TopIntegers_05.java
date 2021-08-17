import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        int [] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < numbers.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] < numbers[j]){
                    flag = true;

                } else {
                    flag = false;
                }

            } if (flag) {
                System.out.printf("%d ", numbers[i]);
            }

        }
        System.out.printf("%d ", numbers[numbers.length-1]);

    }
}
