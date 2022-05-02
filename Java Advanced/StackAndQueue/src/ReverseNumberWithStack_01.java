import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumberWithStack_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        String [] numbers = scan.nextLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);

        }
        while(stack.size() > 0) {
            System.out.print(stack.pop() + " ");

        }
    }
}
