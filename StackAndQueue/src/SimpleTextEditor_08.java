import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque <String> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String command = tokens [0];
            if("1".equals(command) || "2".equals(command)){
                stack.push(text.toString());
                if("1".equals(command)){
                    String textToAppend = tokens[1];
                    text.append(textToAppend);
                } else {
                    int countToErase = Integer.parseInt(tokens[1]);
                    text.setLength(text.length() - countToErase);
                }
            } else if ("3".equals(command)){
                int index = Integer.parseInt(tokens[1]);
                System.out.println(text.charAt(index - 1));
            } else {
                text = new StringBuilder(stack.pop());
            }

        }
    }
}
