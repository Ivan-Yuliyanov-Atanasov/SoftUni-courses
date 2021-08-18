import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int moves = 0;
        String inputLine = scan.nextLine();
        while (!inputLine.equals("end")){
            moves++;
            String [] indexes = inputLine.split(" ");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);
            if ((firstIndex >= 0 && firstIndex < numbers.size()) && (secondIndex >= 0 && secondIndex < numbers.size())){
                String firstElement = numbers.get(firstIndex);
                String secondElement = numbers.get(secondIndex);
                if(firstElement.equals(secondElement)){
                    System.out.printf("Congrats! You have found matching elements - %s!%n",firstElement);
                    numbers.remove(firstElement);
                    numbers.remove(secondElement);
                } else {
                    System.out.println("Try again!");
                }

            } else {
                String elementToAdd = "-" + moves + "a";
                numbers.add(numbers.size() /2,elementToAdd );
                numbers.add((numbers.size() / 2) + 1,elementToAdd);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            if (numbers.isEmpty()){
                System.out.printf("You have won in %d turns!",moves);
                return;
            }
            inputLine = scan.nextLine();
        }
        System.out.println("Sorry you lose :(");
        for (String number : numbers) {
            System.out.print(number + " ");

        }
    }
}
