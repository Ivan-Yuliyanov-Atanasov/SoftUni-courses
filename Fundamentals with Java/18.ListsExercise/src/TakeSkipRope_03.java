import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> text = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        List<Character> output = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)){
                int number = symbol - '0';
                numbers.add(number);
            } else {
                text.add(symbol);
            }

        }
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (i % 2 == 0){
                takeList.add(currentNumber);
            } else {
                skipList.add(currentNumber);
            }

        }
        for (int i = 0; i < takeList.size(); i++) {
            int takeLength = Math.min(takeList.get(i),text.size());
            int j = 1;
            while (j <= takeLength) {
                output.add(text.get(0));
                text.remove(0);
                j++;

            }
            j = 1;
            int skipLength = Math.min(skipList.get(i),text.size());
            while (j <= skipLength) {
                text.remove(0);
                j++;

            }
        }

        for (Character character : output) {
            System.out.print(character);

        }
    }
}
