import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<string>\\D*)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scan.nextLine());
        StringBuilder uniqueSymbols = new StringBuilder();
        StringBuilder message = new StringBuilder();
        int countUniqueSymbols = 0;
        while (matcher.find()){
            String text = matcher.group("string");
            int count = Integer.parseInt(matcher.group("count"));
            String textUppercase = "";
            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);

                if(Character.isLetter(character)){
                    character = Character.toUpperCase(character);
                }
                if(count !=0) {
                    if(!uniqueSymbols.toString().contains(Character.toString(character))){
                        uniqueSymbols.append(character);
                        countUniqueSymbols ++;
                    }
                }

                textUppercase += character;
            }
            for (int i = 0; i < count; i++) {
                message.append(textUppercase);

            }

        }
        System.out.printf("Unique symbols used: %d%n",countUniqueSymbols);
        System.out.println(message.toString());
    }
}
