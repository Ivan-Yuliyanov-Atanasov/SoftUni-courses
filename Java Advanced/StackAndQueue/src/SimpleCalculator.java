import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = input.length - 1; i >=0 ; i--) {
            stack.push(input[i]);

        }
        while(stack.size() > 1){
            int num1 = Integer.parseInt(stack.pop());
            String symbol = stack.pop();
            int num2 = Integer.parseInt(stack.pop());
            int result = symbol.equals("+")
                    ? num1 + num2
                    : num1 - num2;
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());
    }
}
