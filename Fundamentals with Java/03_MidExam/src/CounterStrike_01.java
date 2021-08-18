import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scan.nextLine());
        int wonBattles = 0;
        String inputLine = scan.nextLine();
        while (!inputLine.equals("End of battle")){
            int distance = Integer.parseInt(inputLine);
            if (initialEnergy >= distance){
                initialEnergy -= distance;
                wonBattles ++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",wonBattles, initialEnergy);
                return;
            }
            if(wonBattles % 3 ==0){
                initialEnergy += wonBattles;
            }
            inputLine = scan.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d",wonBattles,initialEnergy);
    }
}
