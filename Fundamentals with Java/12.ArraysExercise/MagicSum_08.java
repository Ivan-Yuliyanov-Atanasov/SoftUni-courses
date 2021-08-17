import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        int magicNumber = Integer.parseInt(scan.nextLine());
        int [] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {

            int num1 = numbers[i];
            for (int j = i + 1; j < numbers.length ; j++) {
                int num2 = numbers[j];
                if (num1 + num2 == magicNumber){
                    System.out.printf("%d %d",num1,num2);
                    System.out.println();
                }

            }

        }
    }

}
