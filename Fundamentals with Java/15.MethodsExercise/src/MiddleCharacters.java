import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int length = input.length();
        getMiddleCharacter(input, length);
    }

    private static void getMiddleCharacter(String input, int length) {
        if (length % 2 == 1){
            System.out.println(input.charAt(length/2));

        } else {
            System.out.print(input.charAt(length/2 - 1));
            System.out.print(input.charAt(length/2));
        }

    }
}
