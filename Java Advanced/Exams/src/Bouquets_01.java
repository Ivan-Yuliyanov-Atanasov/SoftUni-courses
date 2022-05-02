import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Bouquets_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        int [] tulips = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int [] daffodils = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < tulips.length; i++) {
            tulipsStack.push(tulips[i]);

        }
        for (int i = 0; i < daffodils.length; i++) {
            daffodilsQueue.offer(daffodils[i]);

        }
        int bouquets = 0;
        int leftFlowers = 0;
        while(!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()){
            int currentTulip = tulipsStack.peek();
            int currentDaffodil = daffodilsQueue.peek();
            int sum = currentDaffodil + currentTulip;
            if(sum == 15){
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum < 15){
                leftFlowers += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else {
                while(sum > 15){
                    currentTulip -= 2;
                    sum = currentDaffodil + currentTulip;
                    if(sum == 15){
                        bouquets++;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                    } else if(sum < 15){
                        leftFlowers += sum;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                    }
                }
            }
        }
        bouquets += leftFlowers / 15;
        if(bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.",5 - bouquets);
        }
    }
}
