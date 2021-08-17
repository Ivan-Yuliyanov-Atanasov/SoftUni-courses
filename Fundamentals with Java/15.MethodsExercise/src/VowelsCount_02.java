import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        getVowelsCount(input);
    }

    private static void getVowelsCount(String input) {
        int counter = 0;
        int n = input.length();
        for (int i = 0; i <= n-1; i++) {
            char symbol = input.charAt(i);
            switch (symbol){
                case 'a':
                case 'e':
                case 'o':
                case 'i':
                case 'y':
                case 'u':
                case 'A':
                case 'E':
                case 'O':
                case 'I':
                case 'Y':
                case 'U':
                    counter++;
                    break;
            }

        }
        System.out.println(counter);
    }
}
