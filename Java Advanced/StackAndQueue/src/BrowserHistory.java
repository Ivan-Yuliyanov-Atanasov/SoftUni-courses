import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        String URL = scan.nextLine();
        while (!URL.equals("Home")){
            if(URL.equals("back") && history.size() > 1){
                history.pop();
                System.out.println(history.peek());
            } else if(URL.equals("back") && history.size() <= 1){
                System.out.println("no previous URLs");
            } else {
                System.out.println(URL);
                history.push(URL);
            }
            URL = scan.nextLine();
        }
    }
}
