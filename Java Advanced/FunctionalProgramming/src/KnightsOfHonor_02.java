import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] names = scan.nextLine().split("\\s+");
        Consumer<String> printName = str -> System.out.println("Sir " + str);
        Arrays.stream(names).forEach(printName);
    }
}
