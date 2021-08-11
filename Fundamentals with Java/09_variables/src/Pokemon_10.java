import java.util.Scanner;

public class Pokemon_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int power = Integer.parseInt(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());
        int exhaustion = Integer.parseInt(scan.nextLine());
        int counter = 0;
        int startingPower = power;

        while (power >= distance){
            counter ++;
            power -= distance;
            if (power == 0.5 * startingPower){
                if (exhaustion != 0){
                    power /= exhaustion;
                }
            }
        }
        System.out.println(power);
        System.out.println(counter);


    }
}
