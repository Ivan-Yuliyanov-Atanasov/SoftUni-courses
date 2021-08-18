import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<firstLetter>[A-Za-z]{1})(?<number>[\\d]+)(?<secondLetter>[A-Za-z]{1})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scan.nextLine());
        double totalSum = 0.0;
        while (matcher.find()){
            String firstLetter = matcher.group("firstLetter");
            char firstCharacter = firstLetter.charAt(0);
            String secondLetter = matcher.group("secondLetter");
            char secondCharacter = secondLetter.charAt(0);
            double number = Double.parseDouble(matcher.group("number"));

            int positionInAlphabet;
            if(characterIsLowercase(firstCharacter)){
                positionInAlphabet = getPositionInAlphabet(firstCharacter);
                number *= positionInAlphabet;
            } else {
                positionInAlphabet = getPositionInAlphabet(Character.toLowerCase(firstCharacter));
                number /= positionInAlphabet;

            }
            if(characterIsLowercase(secondCharacter)){
                positionInAlphabet = getPositionInAlphabet(secondCharacter);
                number +=  positionInAlphabet;
            } else {
                positionInAlphabet = getPositionInAlphabet(Character.toLowerCase(secondCharacter));
                number -= positionInAlphabet;

            }

            totalSum += number;

        }
        System.out.printf("%.2f",totalSum);
    }

    private static int getPositionInAlphabet(char character) {
        return character - '`';
    }

    private static boolean characterIsLowercase(char character) {
        if(character >= 'a' && character <= 'z'){
            return true;
        }
        return false;
    }
}
