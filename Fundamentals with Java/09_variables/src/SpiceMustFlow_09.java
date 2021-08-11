import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startingYield = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int days = 0;
        while (startingYield >= 100){
            days ++;
            sum += (startingYield - 26);
            startingYield -= 10;

        }
        if (sum >= 26) {
            sum -= 26;
        }
        System.out.println(days);
        System.out.println(sum);
    }
}
