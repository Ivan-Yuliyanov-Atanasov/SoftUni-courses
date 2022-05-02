import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MagicBox_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        int [] firstBoxNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] secondBoxNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < secondBoxNumbers.length; i++) {
            secondBoxStack.push(secondBoxNumbers[i]);

        }
        for (int i = 0; i < firstBoxNumbers.length; i++) {
            firstBoxQueue.offer(firstBoxNumbers[i]);

        }
        int totalSum = 0;
        while(!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstNumber = firstBoxQueue.peek();
            int secondNumber = secondBoxStack.peek();
            int sum = firstNumber + secondNumber;
            if(sum % 2 == 0){
                totalSum += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }

        }
        if(firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        } else if(secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }
        if(totalSum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d",totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d",totalSum);
        }
    }
}
