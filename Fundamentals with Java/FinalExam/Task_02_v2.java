import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "(\\*|@)(?<Tag>[A-Z][a-z]{2,})\\1:\\s{1}\\[(?<firstLetter>[A-Za-z]{1})\\]\\|\\[(?<secondLetter>[A-Za-z]{1})\\]\\|\\[(?<thirdLetter>[A-Za-z]{1})\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 1; i <= n ; i++) {
            String inputLine = scan.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String tag = matcher.group("Tag");
                int firstLetter = matcher.group("firstLetter").charAt(0);
                int secondLetter = matcher.group("secondLetter").charAt(0);
                int thirdLetter = matcher.group("thirdLetter").charAt(0);
                System.out.printf("%s: %d %d %d%n",tag,firstLetter,secondLetter,thirdLetter);

            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
