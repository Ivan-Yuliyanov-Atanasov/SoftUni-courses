import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] inputArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String inputLine;
        while(!(inputLine = scan.nextLine()).equals("end")){
            String [] tokens = inputLine.split(" ");
            String command = tokens[0];
            switch (command){
                case "decrease":
                    decreaseArray(inputArray);
                    break;
                case "multiply":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    int sum = inputArray[firstIndex] * inputArray [secondIndex];
                    inputArray [firstIndex] = sum;
                    break;
                case "swap":
                    int firstSwapIndex = Integer.parseInt(tokens[1]);
                    int secondSwapIndex = Integer.parseInt(tokens[2]);
                    int c = inputArray[firstSwapIndex];
                    inputArray[firstSwapIndex] = inputArray[secondSwapIndex];
                    inputArray[secondSwapIndex] = c;
                    break;
            }
        }
        System.out.println(Arrays.toString(inputArray).replaceAll("[\\[\\]]",""));
    }

    private static void decreaseArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] -= 1;

        }
    }
}
