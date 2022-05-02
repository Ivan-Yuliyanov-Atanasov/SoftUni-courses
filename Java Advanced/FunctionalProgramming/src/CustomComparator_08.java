import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Comparator<Integer> comparator = (firstNumber, secondNumber) -> {
            if(firstNumber % 2 == 0 && secondNumber % 2 != 0){
                return -1;
            } else if (firstNumber % 2 != 0 && secondNumber % 2 == 0){
                return 1;
            } else if((firstNumber % 2 == 0 && secondNumber % 2 == 0) || (firstNumber % 2 != 0 && secondNumber % 2 != 0)){
                if(firstNumber <= secondNumber){
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        };
        numbers.sort(comparator);
        for (Integer integer : numbers) {
            System.out.print(integer + " ");
        }
    }
}
