import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        int [] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean flag = false;
        for (int index = 0; index < numbers.length; index++) {

            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i <= index - 1 ; i++) {
                sumLeft += numbers[i];
            }
            for (int j = index + 1; j <= numbers.length - 1; j++) {
                sumRight += numbers[j];

            }
            if (sumLeft == sumRight){
                flag = true;
                System.out.printf("%d",index);
                break;
            }
        }
        if(!flag) {
            System.out.print("no");
        }

    }
}
