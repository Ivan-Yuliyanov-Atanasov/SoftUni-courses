import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = "";
        Consumer<int []> printArray = arr -> Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        Function<int [], int []> addFunc = arr -> Arrays.stream(arr).map(x -> x += 1).toArray();
        Function<int [], int []> subFunc = arr -> Arrays.stream(arr).map(x -> x -= 1).toArray();
        Function<int [], int []> multiplyFunc = arr -> Arrays.stream(arr).map(x -> x *= 2).toArray();
        while(!(command = scan.nextLine()).equals("end")){
            switch (command){
                case "add":
                    numbers = addFunc.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunc.apply(numbers);

                    break;
                case "subtract":
                    numbers = subFunc.apply(numbers);

                    break;
                case "print":
                    printArray.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}
