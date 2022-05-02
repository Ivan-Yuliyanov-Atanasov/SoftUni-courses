import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            numbers.add(i);

        }
        List<Integer> numbersToDivideTo = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        BiPredicate<Integer,List<Integer>> filter = (num, list) -> {

            for (int i = 0; i < list.size(); i++) {
                if(num % list.get(i) != 0){
                    return false;
                }
            }
            return true;
        };
        numbers.stream()
                .filter(e -> filter.test(e,numbersToDivideTo))
                .forEach(e -> System.out.print((e) + " "));
    }
}
