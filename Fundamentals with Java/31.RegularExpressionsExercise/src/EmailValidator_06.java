import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([A-Za-z0-9]+[\\.\\-_]?[A-Za-z0-9]+)@([A-Za-z-]+).([A-Za-z-]+)(\\.[A-Za-z-]+)*");

        Matcher matcher = pattern.matcher(scan.nextLine());
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
