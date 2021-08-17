import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();
        int length = password.length();
        if(lengthCheck(length) && onlyLettersAndDigitsCheck(password,length) && twoDigitCheck(password, length)){
            System.out.println("Password is valid");
        }
        if (!lengthCheck(length)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!onlyLettersAndDigitsCheck(password, length)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!twoDigitCheck(password,length)){
            System.out.println("Password must have at least 2 digits");
        }

    }

    private static boolean twoDigitCheck(String password, int length) {
        int counter = 0;
        for (int i = 0; i <=password.length() - 1; i++) {
            int n = (int) password.charAt(i);
            if (n >= 48 && n<=57){
                counter++;
            }

        }
        if (counter >= 2){
            return true;
        }
        return false;
    }

    private static boolean lengthCheck (int length) {

        if (length >= 6 && length <= 10){
            return true;
        }
            return false;
        }
    private static boolean onlyLettersAndDigitsCheck (String password, int length){
        boolean flag = true;
        for (int i = 0; i <= length - 1; i++) {
            int n = (int) password.charAt(i);

            if (n>=10 && n<48){
                flag = false;
                break;
            } else if (n >= 91 && n < 97) {
                flag = false;
                break;
            } else if (n >= 172) {
                flag = false;
                break;
            } else if (n>= 58 && n<65){
                flag = false;
                break;
            }

        }
        if(flag){
            return true;
        }
        return false;


    }
}



