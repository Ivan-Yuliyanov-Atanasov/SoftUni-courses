import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> printQueue = new ArrayDeque<>();
        String input = scan.nextLine();
        while(!input.equals("print")){
            if(!input.equals("cancel")){
                printQueue.offer(input);
            } else if(!printQueue.isEmpty()){
                System.out.println("Canceled " + printQueue.poll());
            } else {
                System.out.println("Printer is on standby");
            }
            input = scan.nextLine();
        }
        for (String s : printQueue) {
            System.out.println(s);
        }
    }
}
