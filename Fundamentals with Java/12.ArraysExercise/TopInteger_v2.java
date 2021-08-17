import java.util.Arrays;
import java.util.Scanner;

public class TopInteger_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        int [] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < numbers.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] <= numbers[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.printf("%d ", numbers[i]);
            }
        }


    }
}
