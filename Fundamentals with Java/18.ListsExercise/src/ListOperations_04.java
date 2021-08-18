import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    int n = Integer.parseInt(tokens[1]);
                    numbers.add(n);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);

                       if (indexToRemove >= 0 && indexToRemove < numbers.size()) {
                           numbers.remove(indexToRemove);

                       } else {
                           System.out.println("Invalid index");
                       }
                       break;
                case "Insert" :
                    int indexToInsert = Integer.parseInt(tokens[2]);
                    int numberToInsert = Integer.parseInt(tokens[1]);

                    if (indexToInsert >= 0 && indexToInsert < numbers.size()) {
                        numbers.add(indexToInsert, numberToInsert);

                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift" :
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);

                    if (direction.equals("left")){
                        for (int i = 0; i < count; i++) {
                            numbers.add(numbers.get(i));

                        }
                        int counter = 0;
                        while (counter < count){
                            counter ++;
                            numbers.remove(0);

                        }
                    } else {
                        int counter = 0;
                        while (counter < count){
                            counter ++;
                            numbers.add(0,numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
    }
}