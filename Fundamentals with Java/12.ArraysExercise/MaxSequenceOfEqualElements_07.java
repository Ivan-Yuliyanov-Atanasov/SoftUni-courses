import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        int [] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int maxCounter = 0;
        int numberToPrint = 0;
        for (int index = 0; index <= numbers.length - 1; index++) {
            int counter = 0;
            for (int i = index + 1; i <= numbers.length -1 ; i++) {
                if (numbers[index] == numbers[i]) {
                    counter ++;
                } else {
                    break;
                }
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                numberToPrint = numbers[index];
            }
        }
        if (maxCounter != 0){
            for (int j = 0; j <= maxCounter; j++) {
                System.out.print(numberToPrint + " ");

            }
        }
    }
}
