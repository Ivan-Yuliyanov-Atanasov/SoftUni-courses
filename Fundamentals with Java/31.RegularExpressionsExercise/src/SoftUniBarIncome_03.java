import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^\\|,\\$%]*<(?<product>\\w+)>[^\\|,\\$%]*\\|(?<count>\\d+)\\|[^\\|,\\$%]*?(?<price>[+-]?([0-9]*[.])?[0-9]+)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0.0;
        String inputLine = scan.nextLine();
        while(!inputLine.equals("end of shift")){
            Matcher matcher = pattern.matcher(inputLine);

            while(matcher.find()){
                double totalPrice = 0.0;
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalPrice = count * price;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n",name,product,totalPrice);
            }
            inputLine =scan.nextLine();
        }
        System.out.printf("Total income: %.2f",totalIncome);
    }
}
