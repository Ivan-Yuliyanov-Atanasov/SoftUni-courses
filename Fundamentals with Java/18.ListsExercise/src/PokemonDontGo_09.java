import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        int sum = 0;

        while(!numbers.isEmpty()){
            int index = Integer.parseInt(scan.nextLine());
            int num = 0;
            if (index < 0){
                num = numbers.get(0);
                sum += num;
                numbers.add(0,numbers.get(numbers.size() - 1));
                numbers.remove( 1);
                sumNumbersWithRemovedNumber(numbers,num);


            } else if (index > numbers.size() - 1){
                num = numbers.get(numbers.size() - 1);
                sum += num;
                numbers.remove(numbers.size() - 1);
                numbers.add(numbers.get(0));
                sumNumbersWithRemovedNumber(numbers,num);

            } else {
                num = numbers.get(index);
                sum += num;
                sumNumbersWithRemovedNumber(numbers,num);
                numbers.remove(index);
            }
        }
        System.out.println(sum);


    }

    private static void sumNumbersWithRemovedNumber(List<Integer> numbers, int num) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= num){
                numbers.set(i, numbers.get(i) + num);
            } else {
                numbers.set(i, numbers.get(i) - num);
            }

        }
    }
}
