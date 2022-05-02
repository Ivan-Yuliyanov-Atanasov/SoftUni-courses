import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int currentPlayerRow = 7;
        int currentPlayerCol = 7;

        int playerHealth = 18500;
        double bossHealth = 3000000;
        double damage = Double.parseDouble(scan.nextLine());
        boolean activeCloud = false;
        String lastSpell = "";
        while(true){
            if(playerHealth > 0){
                bossHealth -= damage;
            }

            if(activeCloud){
                playerHealth -= 3500;
                activeCloud = false;

            }
            if(bossHealth <= 0 || playerHealth <= 0){

                break;

            }
            String [] tokens = scan.nextLine().split(" ");
            String spell = tokens[0];
            int spellRow = Integer.parseInt(tokens[1]);
            int spellCol = Integer.parseInt(tokens[2]);
            boolean isPlayerHit = false;
            if(currentPlayerCol == spellCol && currentPlayerRow == spellRow){
                isPlayerHit = true;
            } else if ((spellRow - 1 <= currentPlayerRow && currentPlayerRow <= spellRow + 1) &&
                    (spellCol - 1 <= currentPlayerCol && currentPlayerCol <= spellCol + 1)) {
                if((currentPlayerRow - 1 < spellRow - 1) && currentPlayerRow - 1 >= 0){
                    currentPlayerRow --;
                } else if ((spellCol + 1 < currentPlayerCol + 1) && currentPlayerCol + 1 < 15){
                    currentPlayerCol++;
                } else if ((currentPlayerRow + 1 > spellRow + 1) && currentPlayerRow + 1 < 15){
                    currentPlayerRow ++;
                } else if((currentPlayerCol - 1 < spellCol - 1) && currentPlayerCol - 1 >= 0){
                    currentPlayerCol --;
                } else {
                    isPlayerHit = true;
                }
            }
            if(isPlayerHit){
                if(spell.equals("Cloud")){
                    activeCloud = true;
                    playerHealth -= 3500;
                    lastSpell = "Plague Cloud";
                } else {
                    playerHealth -= 6000;
                    lastSpell = "Eruption";
                }
            }

        }
        if(bossHealth > 0 && playerHealth <= 0){
            System.out.printf("Heigan: %.2f%n",bossHealth);
            System.out.printf("Player: Killed by %s%n",lastSpell);

        } else if (playerHealth > 0 && bossHealth <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n",playerHealth);
        } else {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: Killed by %s%n",lastSpell);
        }
        System.out.printf("Final position: %d, %d",currentPlayerRow,currentPlayerCol);
    }
}
