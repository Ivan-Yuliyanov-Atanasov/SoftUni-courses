import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        double timeFirstCar = 0;
        double timeSecondCar = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {
            if(numbers.get(i) == 0){
                timeFirstCar *= 0.8;
            } else {
                timeFirstCar += numbers.get(i);
            }

        }
        for (int i = numbers.size() - 1; i > numbers.size() / 2 ; i--) {
            if(numbers.get(i) == 0){
                timeSecondCar *= 0.8;
            } else {
                timeSecondCar += numbers.get(i);
            }

        }
        if (timeFirstCar < timeSecondCar){
            System.out.printf("The winner is left with total time: %.1f",timeFirstCar);
        } else {
            System.out.printf("The winner is right with total time: %.1f",timeSecondCar);
        }
    }
}
