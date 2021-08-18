import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        while (!input.equals("end")) {

            String command = input.split(" ")[0];
            if (command.equals("Add")) {
                int newWagon = Integer.parseInt(input.split(" ")[1]);
                wagons.add(newWagon);

            } else {
                int passengers = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    int number = wagons.get(i);
                    int diff = maxCapacity - number;
                    if (diff >= passengers) {
                        wagons.set(i,number + passengers);
                        break;
                    }

                }
            }

            input = scan.nextLine();

        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");

        }

        
    }
}
