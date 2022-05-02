import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String command = tokens[0];
            if("2".equals(command)) {
                stack.pop();
            } else if("1".equals(command)) {
                int number = Integer.parseInt(tokens[1]);
                stack.push(number);
            } else {
                int maxNumber = stack.stream().max(Integer::compare).get();
                System.out.println(maxNumber);
            }

        }
    }

}
