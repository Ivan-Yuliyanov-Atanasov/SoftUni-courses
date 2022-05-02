import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TheSmallestInteger_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> getIndex = list -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if(min >= list.get(i)){
                    min = list.get(i);
                    index = i;
                }
            }
            return index;
        };
        int index = getIndex.apply(numbers);
        System.out.println(index);
    }
}
