import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern namePattern = Pattern.compile("@([A-Za-z]+)\\|");
        Pattern agePattern = Pattern.compile("#(\\d+)\\*");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String inputLine = scan.nextLine();
            Matcher nameMatcher = namePattern.matcher(inputLine);
            Matcher ageMatcher = agePattern.matcher(inputLine);
            String name = "";
            String age = "";
            if(nameMatcher.find() && ageMatcher.find()){
                name = nameMatcher.group(1);
                age = ageMatcher.group(1);
            }
            System.out.printf("%s is %s years old.%n",name,age);

        }
    }
}
