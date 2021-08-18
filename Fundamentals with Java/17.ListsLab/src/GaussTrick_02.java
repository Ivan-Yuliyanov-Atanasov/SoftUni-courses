import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String inputLine = scan.nextLine();
        numbers = Arrays.stream(inputLine.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = numbers.size();
        for (int i = 0; i < numbers.size() / 2; i++) {
            numbers.set(i,numbers.get(i) + numbers.get(numbers.size() - 1 - i));

        }
        for (int i = 0; i < n / 2; i++) {
            numbers.remove(n - 1 -i);

        }
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
    }
}