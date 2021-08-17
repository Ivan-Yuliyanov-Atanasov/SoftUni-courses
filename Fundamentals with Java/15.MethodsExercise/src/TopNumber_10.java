import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 17; i <= num ; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            int [] array = getArray(i, length);
            if (isSumOfDigitsDivisibleByEight(array) && oneOddDigits(array)){
                System.out.println(i);
            }
        }
    }
    static int [] getArray(int number, int length){
        int [] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[length - 1 - i] = number % 10;
            number /= 10;

        }
        return array;

    }
    static boolean isSumOfDigitsDivisibleByEight (int [] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % 8 == 0){
            return true;
        }
        return false;
    }
    static boolean oneOddDigits (int [] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                return true;
            }

        }
        return false;
    }
}
