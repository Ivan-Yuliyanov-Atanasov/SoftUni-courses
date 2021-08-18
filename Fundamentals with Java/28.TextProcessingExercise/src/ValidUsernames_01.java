import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            String currentWord = input[i];
            int n = currentWord.length();
            boolean toPrint = true;
            if (n < 3 || n > 16){
                toPrint = false;
            }
            if(!checkCharacter(currentWord,n)){
                toPrint = false;
            }

            if (toPrint){
                System.out.println(currentWord);
            }
        }

    }

    private static boolean checkCharacter(String currentWord, int n) {
        for (int i = 0; i < n; i++) {
            char symbol = currentWord.charAt(i);
            if (!Character.isDigit(symbol) && !Character.isLetter(symbol) && symbol != '-' && symbol != '_'){
                return false;
            }

        }
        return true;
    }
}
