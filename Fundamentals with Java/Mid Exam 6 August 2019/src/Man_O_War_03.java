import java.util.Arrays;
import java.util.Scanner;

public class Man_O_War_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] pirateShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int [] warShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int maximumHealth = Integer.parseInt(scan.nextLine());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Retire")){
            String [] tokens = inputLine.split(" ");
            String command = tokens[0];
            switch (command){
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damageToWarship = Integer.parseInt(tokens[2]);
                    if(index >= 0 && index < warShip.length){
                        warShip[index] -= damageToWarship;
                        if(warShip[index] <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damageToPirateShip = Integer.parseInt(tokens[3]);
                    if((startIndex >= 0 && startIndex < pirateShip.length) && (endIndex >= 0 && endIndex < pirateShip.length)){
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damageToPirateShip;
                            if(pirateShip[i] <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if(indexToRepair >= 0 && indexToRepair < pirateShip.length){
                        pirateShip[indexToRepair] += health;
                        if (pirateShip[indexToRepair] > maximumHealth){
                            pirateShip[indexToRepair] = maximumHealth;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < maximumHealth * 0.2){
                            count++;
                        }

                    }
                    if(count != 0){
                        System.out.printf("%d sections need repair.%n",count);
                    }
                    break;

            }

            inputLine = scan.nextLine();
        }
        int pirateShipStatus = 0;
        for (int i : pirateShip) {
            pirateShipStatus += i;

        }
        int warShipStatus = 0;
        for (int i : warShip) {
            warShipStatus += i;

        }
        System.out.printf("Pirate ship status: %d%n",pirateShipStatus);
        System.out.printf("Warship status: %d",warShipStatus);
    }
}
