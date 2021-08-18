import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] parts = scan.nextLine().split("\\|");
        String regexCapitalLetters = "(%|#|\\$|\\*|&)([A-Z]*)\\1";
        Pattern patternCapitalLetters = Pattern.compile(regexCapitalLetters);
        Matcher matcherCapitalLetters = patternCapitalLetters.matcher(parts[0]);
        String regexSecondPart = "(?<code>\\d{2}):(?<length>\\d{2})";
        Pattern patternSecondPart = Pattern.compile(regexSecondPart);
        Matcher matcherSecondPart = patternSecondPart.matcher(parts[1]);
        String regexThirdPart = "(\\b[A-Z][\\S]*\\b)";
        Pattern patternThirdPart = Pattern.compile(regexThirdPart);
        Matcher matcherThirdPart = patternThirdPart.matcher(parts[2]);
        String capitalLetters = "";
        List<String> output = new ArrayList<>();
        while (matcherCapitalLetters.find()){
            capitalLetters += matcherCapitalLetters.group(2);
        }

        while (matcherSecondPart.find()){
            int code = Integer.parseInt(matcherSecondPart.group("code"));
            int length = Integer.parseInt(matcherSecondPart.group("length"));
            for (int i = 0; i < capitalLetters.length(); i++) {
                if(capitalLetters.charAt(i) == code){
                    output.add(capitalLetters.substring(i,i + 1));
                    output.add(String.valueOf(length + 1));
                    capitalLetters = capitalLetters.substring(0,i) + capitalLetters.substring(i + 1);
                }

            }
        }
        List<String> wordsThirdPart = new ArrayList<>();
        while(matcherThirdPart.find()) {
            wordsThirdPart.add(matcherThirdPart.group().trim());
        }
        for (int i = 0; i < output.size(); i += 2) {
            char capitalLetter = output.get(i).charAt(0);
            int length = Integer.parseInt(output.get( i + 1));
            for (int j = 0; j < wordsThirdPart.size(); j++) {
                String word = wordsThirdPart.get(j);
                char firstLetter = word.charAt(0);
                int wordLength = word.length();
                if(capitalLetter == firstLetter && length == wordLength){
                    System.out.println(word);
                }

            }

        }

    }
}
