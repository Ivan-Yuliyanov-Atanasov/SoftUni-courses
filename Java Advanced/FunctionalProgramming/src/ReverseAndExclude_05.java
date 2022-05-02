import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());
        Predicate<Integer> filter = e -> e % n != 0;
        List<Integer> filteredList = numbers.stream().filter(filter).collect(Collectors.toList());
        Collections.reverse(filteredList);
        for (Integer integer : filteredList) {
            System.out.print(integer + " ");
        }
    }
}
