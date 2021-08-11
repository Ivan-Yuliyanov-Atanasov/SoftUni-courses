import java.util.Scanner;

public class Task_01_v2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceFlour = Double.parseDouble(scan.nextLine());
        double priceEgg = Double.parseDouble(scan.nextLine());
        double priceApron = Double.parseDouble(scan.nextLine());

        int countEggs = students * 10;
        double countApron = Math.ceil(students * 0.2) + students;
        int counter = 0;
        for (int i = 5; i <= students; i++) {
            if( i % 5 == 0){
                counter++;
            }
        }
        int countFlour = students - counter;

        double totalPrice = countEggs * priceEgg + countApron * priceApron + countFlour * priceFlour;
        double diff = totalPrice - budget;

        if (budget >= totalPrice){

            System.out.printf("Items purchased for %.2f$.",totalPrice);
        } else {
            System.out.printf("%.2f$ more needed.",diff);
        }
    }
}



