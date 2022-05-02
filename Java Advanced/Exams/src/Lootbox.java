import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stack::push);
        int total = 0;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstNumber = queue.peek();
            int secondNumber = stack.peek();
            int sum = firstNumber + secondNumber;
            if (sum % 2 == 0) {
                total += sum;
                queue.poll();
                stack.pop();
            } else {
                queue.offer(stack.pop());
            }
        }
        String output = queue.isEmpty() ? "First lootbox is empty" : "Second lootbox is empty";
        String output1 = total >= 100 ? "Your loot was epic! Value: " : "Your loot was poor... Value: ";

        System.out.println(output);
        System.out.println(output1 + total);

    }
}
