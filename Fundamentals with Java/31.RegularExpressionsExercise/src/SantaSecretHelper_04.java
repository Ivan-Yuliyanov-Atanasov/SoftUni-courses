import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> messages = new ArrayList<>();
        String inputLine = scan.nextLine();
        while (!inputLine.equals("end")){
            StringBuilder newMessage = new StringBuilder();
            for (int i = 0; i < inputLine.length(); i++) {
                char characterReduced = (char) (inputLine.charAt(i) - n);
                newMessage.append(characterReduced);
            }
            messages.add(newMessage.toString());
            inputLine = scan.nextLine();
        }
        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<grade>[G])!";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < messages.size(); i++) {
            String text = messages.get(i);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String name = matcher.group("name");
//                String grade = matcher.group("grade");
//                if(grade.equals("G")){
                    System.out.println(name);
//                }
            }
        }

    }

}
