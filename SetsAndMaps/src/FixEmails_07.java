import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> map = new LinkedHashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = "";
        while(!(input = scan.nextLine()).equals("stop")){
            queue.offer(input);
        }
        int size = queue.size();
        for (int i = 0; i < size / 2; i++) {
            String name = queue.poll();
            String email = queue.poll();
            assert email != null;
            if(!email.endsWith("uk") && !email.endsWith("com") && !email.endsWith("us")){
                map.put(name,email);
            }

        }
        for (Map.Entry <String,String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());

        }
    }
}
