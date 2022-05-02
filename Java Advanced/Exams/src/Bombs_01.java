import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bombs_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        int [] bombEffects = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int [] bombCasings = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < bombEffects.length; i++) {
            bombEffectQueue.offer(bombEffects[i]);
        }
        for (int i = 0; i < bombCasings.length; i++) {
            bombCasingStack.push(bombCasings[i]);
        }
        int daturaBomb = 0;
        int cherryBomb = 0;
        int smokeDecoyBomb = 0;
        boolean pouch = false;



        while(!bombCasingStack.isEmpty() && !bombEffectQueue.isEmpty()){
            int currentBombEffect = bombEffectQueue.peek();
            int currentBombCasing = bombCasingStack.peek();
            int sum = currentBombCasing + currentBombEffect;
            if(sum == 40 || sum == 60 || sum == 120){
                if(sum == 40){
                    daturaBomb++;
                } else if(sum == 60){
                    cherryBomb++;
                } else {
                    smokeDecoyBomb++;
                }
                bombCasingStack.pop();
                bombEffectQueue.poll();
            } else {
                bombCasingStack.push(bombCasingStack.pop() - 5);
            }
            if((daturaBomb >= 3) && (cherryBomb >= 3) && (smokeDecoyBomb >= 3)){
                pouch = true;
                break;
            }
        }
        if(pouch){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if(!bombEffectQueue.isEmpty()){
            System.out.println("Bomb Effects: " + bombEffectQueue.toString().replace("[","").replace("]",""));
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!bombCasingStack.isEmpty()){
            System.out.println("Bomb Casings: " + bombCasingStack.toString().replace("[","").replace("]",""));
        } else {
            System.out.println("Bomb Casings: empty");
        }
        System.out.println("Cherry Bombs: " + cherryBomb);
        System.out.println("Datura Bombs: " + daturaBomb);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBomb);



    }
}
