import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(input));
        int n = Integer.parseInt(scan.nextLine());
        int counter = 1;
        int cycle = 1;


            while (queue.size() > 1) {

                for (int i = 1; i < n; i++)
                    queue.offer(queue.poll());

                if (cycleIsNotPrime(cycle) || cycle == 1)
                    System.out.println("Removed " + queue.poll());
                else
                    System.out.println("Prime " + queue.peek());


                cycle++;
            }


//            String currentChild = children.poll();
//            if(counter % n == 0 && (cycleIsNotPrime(cycle) || cycle == 1)){
//                System.out.println("Removed " + currentChild);
//                cycle++;
//            } else if (counter % n == 0 && !cycleIsNotPrime(cycle)){
//                children.offer(currentChild);
//                System.out.println("Prime " + currentChild);
//                cycle++;
//            } else {
//                children.offer(currentChild);
//            }
//            counter ++;
//        }
            System.out.println("Last is " + queue.peek());

        }



    private static boolean cycleIsNotPrime(int cycle) {
        for (int i = 2; i <= cycle / 2; ++i) {
            // condition for nonprime number
            if (cycle % i == 0) {
                return true;

            }
        }
        return false;
    }


}

