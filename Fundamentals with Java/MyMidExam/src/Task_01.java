import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceFlour = Double.parseDouble(scan.nextLine());
        double priceEgg = Double.parseDouble(scan.nextLine());
        double priceApron = Double.parseDouble(scan.nextLine());

        double totalPriceEggs = students * 10 * priceEgg;
        double totalPriceFlour = (students - students / 5) * priceFlour;




        int countApron = (int)Math.ceil(1.2 * students);
        double totalPriceApron =  countApron * priceApron;
        double totalPrice = totalPriceApron + totalPriceEggs + totalPriceFlour;
        double diff = totalPrice - budget;
        if (budget < totalPrice){
            System.out.printf("%.2f$ more needed.",diff);
        } else {
            System.out.printf("Items purchased for %.2f$.",totalPrice);
        }
    }
}
