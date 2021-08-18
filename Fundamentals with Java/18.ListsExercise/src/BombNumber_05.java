import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        String [] input = scan.nextLine().split(" ");
        int bombNumber = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);
        while (numbers.contains(bombNumber)){
            int currentIndex = numbers.indexOf(bombNumber);
            int rightLength = Math.min(bombPower, (numbers.size() - 1 - currentIndex));
            int leftLength = Math.min(currentIndex, bombPower);
            int counterRight = 0;
            int counterLeft = 0;
            while (counterRight < rightLength){
                counterRight ++;
                numbers.remove(currentIndex + 1);
            }
            while (counterLeft <= leftLength){
                counterLeft ++;
                numbers.remove(currentIndex - leftLength);
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;

        }
        System.out.println(sum);
    }
}
