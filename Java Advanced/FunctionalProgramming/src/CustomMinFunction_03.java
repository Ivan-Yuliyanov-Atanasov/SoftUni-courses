import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .sorted().limit(1).forEach(System.out::println);
    }
}
