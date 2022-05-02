import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        Map<Character,Integer> symbols = new TreeMap<>();
        for (int i = 0; i < inputLine.length(); i++) {
            char symbol = inputLine.charAt(i);
            if(!symbols.containsKey(symbol)){
                symbols.put(symbol,1);
            } else {
                symbols.put(symbol,symbols.get(symbol) + 1);
            }

        }
        for (Map.Entry <Character,Integer> map : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n",map.getKey(),map.getValue());

        }
    }
}
