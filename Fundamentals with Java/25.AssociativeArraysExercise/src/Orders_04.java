import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> quantityList = new LinkedHashMap<>();
        Map<String, Double> priceList = new LinkedHashMap<>();
        String input = scan.nextLine();
        while(!input.equals("buy")){
            String [] tokens = input.split(" ");
            String key = tokens[0];
            double singlePrice = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);
            quantityList.putIfAbsent(key,0);
            quantityList.put(key,quantityList.get(key) + quantity);

            priceList.put(key,singlePrice);

            input = scan.nextLine();
        }


        for(Map.Entry<String, Double> entry: priceList.entrySet()){
            double sum = entry.getValue() * quantityList.get(entry.getKey());
            System.out.printf("%s -> %.2f%n",entry.getKey(),sum);
        }
    }
}
