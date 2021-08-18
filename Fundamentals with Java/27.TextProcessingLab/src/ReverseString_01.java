import java.util.Scanner;

public class ReverseString_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!input.equals("end")){
            StringBuilder reverseString = new StringBuilder();
            for (int i = input.length() - 1; i >= 0 ; i--) {
                char symbol = input.charAt(i);
                reverseString.append(symbol);

            }
            System.out.println(input + " = " + reverseString.toString());


            input = scan.nextLine();
        }
    }
}
