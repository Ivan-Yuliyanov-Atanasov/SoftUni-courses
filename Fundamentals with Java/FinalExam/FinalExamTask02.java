import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamTask02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String tagRegex = "(\\*|@)(?<Tag>[A-Z][a-z]{2,})\\1:\\s{1}";
        String letterRegex = "(\\[(?<Letter>\\w{1})\\]\\|)";
        Pattern tagPattern = Pattern.compile(tagRegex);
        Pattern letterPattern = Pattern.compile(letterRegex);
        for (int i = 1; i <= n ; i++) {
            String inputLine = scan.nextLine();
            Matcher tagMatcher = tagPattern.matcher(inputLine);
            if(tagMatcher.find()){
                String tag = tagMatcher.group("Tag");
                List<Integer> letters= new ArrayList<>();
                Matcher letterMatcher = letterPattern.matcher(inputLine);
                while (letterMatcher.find()){
                    letters.add((int)(letterMatcher.group("Letter")).charAt(0));

                }
                if (letters.size()==3){
                    System.out.print(tag + ": ");
                    for (int j = 0; j < letters.size(); j++) {
                        System.out.print(letters.get(j) + " ");

                    }
                    System.out.println();
                } else {
                    System.out.println("Valid message not found!");
                }

            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
