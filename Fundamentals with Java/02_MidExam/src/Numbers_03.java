import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> toPrint = new ArrayList<>();
        double average = getAverage(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > average){
                toPrint.add(numbers.get(i));
            }

        }
        if (toPrint.isEmpty()){
            System.out.println("No");

        } else {
            toPrint.stream()
                    .sorted((num1, num2) -> Integer.compare(num2, num1))
                    .limit(5)
                    .forEach(num -> System.out.print(num + " "));
        }


        System.out.println();
    }

    private static double getAverage(List<Integer> numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);

        }
        return sum / numbers.size();
    }

}
