import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int daysPlunder = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double totalPlunder = 0;
        for (int i = 1; i <= daysPlunder; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0){
                totalPlunder += 0.5 * dailyPlunder;
            }
            if (i % 5 == 0){
                totalPlunder = totalPlunder * 0.7;
            }

        }
        if(totalPlunder >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",totalPlunder);
        } else {
            double collectedPlunder = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",collectedPlunder);
        }


    }
}
