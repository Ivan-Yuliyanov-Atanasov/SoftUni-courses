import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().replace(" ", "");

        Map<Character, Integer> lettersCount = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!lettersCount.containsKey(symbol)){
                lettersCount.put(symbol, 1);
            } else {
                lettersCount.put(symbol,lettersCount.get(symbol) + 1);
            }

        }
        for ( Map.Entry<Character, Integer> entry : lettersCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
