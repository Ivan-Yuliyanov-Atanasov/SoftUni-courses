import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")){
            int length = input.length();
            int num = Integer.parseInt(input);
            System.out.println(isPalindromeNumber(num, length));
            input = scan.nextLine();
        }
    }
    static boolean isPalindromeNumber(int number, int length){
        int [] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[length - 1 - i] = number % 10;
            number /= 10;

        }
        for (int i = 0; i < length/2 ; i++) {
            if (digits[i] != digits[length - 1 - i]){
                return false;
            }
        }
        return true;
    }
}
