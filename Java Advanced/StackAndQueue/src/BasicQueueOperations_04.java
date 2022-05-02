import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        String [] tokens = scan.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);
        String [] numbers = scan.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            stack.offer(Integer.parseInt(numbers[i]));

        }
        for (int i = 0; i < s; i++) {
            stack.poll();

        }
        if(stack.contains(x)){
            System.out.println("true");
        } else {
            if (stack.size() == 0){
                System.out.println(0);
            } else {
                int minNumber = stack.stream().min(Integer::compare).get();
                System.out.println(minNumber);
            }
        }
    }

}
