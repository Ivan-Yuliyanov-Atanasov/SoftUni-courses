import java.util.Arrays;
import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] rooms = scan.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        for (int i = 0; i < rooms.length; i++) {
            String [] tokens = rooms[i].split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            switch (command){
                case "potion":
                    int currentHealth = health;
                    health += value;
                    if(health > 100){
                        health = 100;
                        System.out.printf("You healed for %d hp.%n",100 - currentHealth);
                    } else {
                        System.out.printf("You healed for %d hp.%n",value);
                    }
                    System.out.printf("Current health: %d hp.%n",health);
                    break;
                case "chest":
                    bitcoins += value;
                    System.out.printf("You found %d bitcoins.%n", value);
                    break;
                default:
                    health -= value;
                    if(health > 0){
                        System.out.printf("You slayed %s.%n",command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n",command);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    }

                    break;
            }

        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n",bitcoins);
        System.out.printf("Health: %d%n",health);
    }
}
