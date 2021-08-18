import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int numbers1Length = numbers1.size();
        int numbers2Length = numbers2.size();
        for (int i = 0; i < Math.min(numbers1Length,numbers2Length); i++) {
            mixedList.add(numbers1.get(i));
            mixedList.add(numbers2.get(numbers2.size() - 1 - i));

        }
        int range1 = 0;
        int range2 = 0;
        if (numbers1Length > numbers2Length){
            range1 = numbers1.get(numbers1.size() - 1);
            range2 = numbers1.get(numbers1.size() - 2);
        } else {
            range1 = numbers2.get(0);
            range2 = numbers2.get(1);
        }
        int border1 = Math.min(range1,range2);
        int border2 = Math.max(range1,range2);
        for (int i = 0; i < mixedList.size(); i++) {
            int number = mixedList.get(i);
            if (number > border1 && number < border2){
                output.add(number);
            }

        }
        output.stream()
                .sorted((n1, n2) -> Integer.compare(n1, n2))
                .forEach(e -> System.out.print((e) + " "));



    }
}
