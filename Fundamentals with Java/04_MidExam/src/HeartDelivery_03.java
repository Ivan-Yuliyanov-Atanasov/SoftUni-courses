import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] houses = Arrays.stream(scan.nextLine().split("@")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String inputLine = scan.nextLine();
        int startingIndex = 0;
        while (!inputLine.equals("Love!")){
            int jumpLength = Integer.parseInt(inputLine.split(" ")[1]);
            int currentIndex = startingIndex + jumpLength;
            if(currentIndex < houses.length){
                startingIndex = currentIndex;
                if(houses[currentIndex] != 0){
                    houses[currentIndex] -= 2;
                    if (houses[currentIndex] == 0){
                        System.out.printf("Place %d has Valentine's day.%n",currentIndex);
                    }
                } else {
                    System.out.printf("Place %d already had Valentine's day.%n",currentIndex);
                }
            } else {
                startingIndex = 0;
                if(houses[0] != 0){
                    houses[0] -= 2;
                    if (houses[0] == 0){
                        System.out.printf("Place 0 has Valentine's day.%n");
                    }
                } else {
                    System.out.printf("Place 0 already had Valentine's day.%n");
                }
            }
            inputLine = scan.nextLine();
        }
        int failedPlaces = 0;
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] != 0){
                failedPlaces ++;
            }

        }
        System.out.printf("Cupid's last position was %d.%n",startingIndex);
        if (failedPlaces == 0){
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.",failedPlaces);
        }
    }
}
