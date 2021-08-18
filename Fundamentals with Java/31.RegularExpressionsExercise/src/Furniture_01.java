import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)\\b";
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);
        List<String> output = new ArrayList<>();
        double sum = 0;
        while(!text.equals("Purchase")){
            Matcher matcher = pattern.matcher(text);
            if(matcher.find()){
                output.add(matcher.group("furniture"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum += price * quantity;
            }

            text = scan.nextLine();
            
        }
        System.out.println("Bought furniture:");
        for (String furniture : output) {
            System.out.println(furniture);

        }
        System.out.printf("Total money spend: %.2f",sum);
    }
}
