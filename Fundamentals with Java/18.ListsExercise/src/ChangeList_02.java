import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Delete":
                    int numToRemove = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == numToRemove) {
                            numbers.remove(i);
                            i--;

                        }
                    }
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    numbers.add(index,numToInsert);

                }
                input = scan.nextLine();

            }
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
        }


    }

