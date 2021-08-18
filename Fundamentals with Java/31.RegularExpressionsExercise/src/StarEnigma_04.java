import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String [] messages = new String[n];

        Pattern patternSymbols = Pattern.compile("[SsTtaArR]+");
        for (int i = 0; i < n; i++) {
            String inputLine = scan.nextLine();
            Matcher symbolMatcher = patternSymbols.matcher(inputLine);
            int count = 0;
            while (symbolMatcher.find()){
               count += symbolMatcher.group().length();
            }

            StringBuilder message = new StringBuilder();
            for (int j = 0; j < inputLine.length(); j++) {
                char character = (char) (inputLine.charAt(j) - count);
                message.append(character);

            }
            messages[i] = message.toString();

        }
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!>:]*:(?<population>\\d+)[^@\\-!>:]*!(?<type>[AD])![^@\\-!>:]*->(?<soldiercount>\\d+)");
        for (int i = 0; i < messages.length; i++) {
            String text = messages[i];
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String name = matcher.group("name");
                if (matcher.group("type").equals("A")){
                    attacked.add(name);
                } else {
                    destroyed.add(name);
                }
            }

        }
        Collections.sort(attacked);
        Collections.sort(destroyed);
        System.out.printf("Attacked planets: %d%n",attacked.size());
        for (String s : attacked) {
            System.out.println("-> " + s);
        }
        System.out.printf("Destroyed planets: %d%n",destroyed.size());
        for (String s : destroyed) {
            System.out.println("-> " + s);
        }
    }
}
