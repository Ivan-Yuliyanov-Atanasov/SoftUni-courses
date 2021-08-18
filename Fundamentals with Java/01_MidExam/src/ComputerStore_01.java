import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        double priceWithoutTaxes = 0;
        double taxes = 0;
        while((!inputLine.equals("special")) && (!inputLine.equals("regular"))){
            if (Double.parseDouble(inputLine) < 0){
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += Double.parseDouble(inputLine);
                taxes += Double.parseDouble(inputLine) * 0.2;
            }

            inputLine = scan.nextLine();
        }
        double totalPrice = priceWithoutTaxes + taxes;
        if (inputLine.equals("special")){
            totalPrice = totalPrice * 0.9;
        }
        if (totalPrice == 0){
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalPrice);
        }
    }
}
