import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if(symbol == '('){
                stack.push(i);
            } else if (symbol == ')'){
                int endIndex = i;
                int startIndex = stack.pop();
                System.out.println(input.substring(startIndex,endIndex + 1));
            }

        }

    }
}
