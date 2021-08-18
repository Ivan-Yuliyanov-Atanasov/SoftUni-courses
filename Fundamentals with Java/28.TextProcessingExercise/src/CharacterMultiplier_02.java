import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(" ");
        String word1 = input[0];
        String word2 = input[1];
        int length1 = word1.length();
        int length2 = word2.length();
        int sum = 0;
        if (length1 > length2){
            int sumLeftLetters = 0;
            for (int i = length2; i < length1; i++) {
                int digit = (int) word1.charAt(i);
                sumLeftLetters += digit;

            }
            sum += (sumLeftLetters + getSum(word1,word2,length2));
        } else if ( length1 < length2){
            int sumLeftLetters = 0;
            for (int i = length1; i < length2; i++) {
                int digit = (int) word2.charAt(i);
                sumLeftLetters += digit;

            }
            sum += (sumLeftLetters + getSum(word1,word2,length1));
        } else {
            sum += getSum(word1, word2, length1);
        }
        System.out.println(sum);

    }
    static Integer getSum(String word1, String word2, int length){
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int symbol1 = (int) word1.charAt(i);
            int symbol2 = (int) word2.charAt(i);
            sum = sum + symbol1 * symbol2;

        }
        return sum;
    }

}
