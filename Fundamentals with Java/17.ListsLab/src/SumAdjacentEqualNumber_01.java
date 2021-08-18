import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumber_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers = new ArrayList<>();
        String inputLine = scan.nextLine();
        numbers = Arrays.stream(inputLine.split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, (numbers.get(i) + numbers.get(i + 1)));
                numbers.remove(i + 1);
                i = -1;

            }

        }
        String output = joinElementsByDelimeter(numbers, " ");
        System.out.println(output);


    }

    private static String joinElementsByDelimeter(List<Double> numbers, String delimiter) {
        String output = "";
        for (Double number : numbers) {
            output += (new DecimalFormat("0.#").format(number) + delimiter);
        }
        return output;

    }

}


