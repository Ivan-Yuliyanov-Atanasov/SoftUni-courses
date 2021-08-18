import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFind_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String keys = scan.nextLine().replace(" ","");
        String inputLine = scan.nextLine();
        while (!inputLine.equals("find")){
            StringBuilder decryptedMessage = new StringBuilder();
            if (inputLine.length() > keys.length()){
                keys = getKeysNewLength(keys,inputLine);
            }
            for (int i = 0; i < inputLine.length(); i++) {
                char currentSymbol = inputLine.charAt(i);
                int currentKey = keys.charAt(i) - '0';
                char toAdd = (char) (currentSymbol - currentKey);
                decryptedMessage.append(toAdd);
            }

            Pattern typePattern = Pattern.compile("&([A-Za-z]+)&");
            Pattern coordinatesPattern = Pattern.compile("<([A-Za-z0-9]+)>");
            Matcher typeMatcher = typePattern.matcher(decryptedMessage.toString());
            Matcher coordinatesMatcher = coordinatesPattern.matcher(decryptedMessage.toString());
            if(typeMatcher.find() && coordinatesMatcher.find()){
                System.out.printf("Found %s at %s%n",typeMatcher.group(1),coordinatesMatcher.group(1));
            }


            inputLine = scan.nextLine();
        }

    }

    private static String getKeysNewLength(String keys, String inputLine) {
        StringBuilder keysHelp = new StringBuilder();
        int n = inputLine.length() / keys.length() + 1;
        for (int i = 0; i < n; i++) {
            keysHelp.append(keys);
        }

        return keysHelp.toString();
    }

}
