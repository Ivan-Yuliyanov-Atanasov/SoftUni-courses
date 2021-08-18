import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        String message = scan.nextLine();
        String output = "";
        for (int i = 0; i < numbers.size(); i++) {

            int length = message.length() - 1;
            int currentElement = numbers.get(i);
            int sum = getSum(currentElement);
            int index = sum;
            if (sum > length){
                index = sum / (length - 1);
            }

            output += message.charAt(index);
            String newMessage = message.substring(0,index) + message.substring(index + 1);
            message = newMessage;
            }
        System.out.println(output);

        }

    private static int getSum(int currentElement) {
        int sum = 0;
        while (currentElement > 0){
            sum += currentElement % 10;
            currentElement /= 10;
        }
        return sum;
    }

}

