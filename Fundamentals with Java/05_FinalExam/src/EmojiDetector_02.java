import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        BigInteger threshold = new BigInteger("1");
        for (int i = 0; i < inputLine.length(); i++) {

            if(Character.isDigit(inputLine.charAt(i))){
                BigInteger number = new BigInteger(Character.toString(inputLine.charAt(i)));
                threshold = threshold.multiply(number);
            }

        }
        String regex = "(:|\\*){2}([A-Z][a-z]{2,})\\1{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLine);
        int counter = 0;
        List<String> emojis = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        while(matcher.find()){
            counter++;
            String emoji = matcher.group(2);
            int score = 0;
            for (int i = 0; i < emoji.length(); i++) {
                score += emoji.charAt(i);

            }
            if(BigInteger.valueOf(score).compareTo(threshold) > 0){
                String concat = matcher.group(1) + matcher.group(1) + matcher.group(2) + matcher.group(1) + matcher.group(1);
                emojis.add(concat);
                scores.add(score);
            }

        }
        System.out.printf("Cool threshold: %s%n",threshold);
        if(counter != 0){
            System.out.printf("%d emojis found in the text. The cool ones are:%n",counter);
            for (int i = 0; i < emojis.size(); i++) {
                System.out.printf("%s%n",emojis.get(i));

            }
        }
    }
}
