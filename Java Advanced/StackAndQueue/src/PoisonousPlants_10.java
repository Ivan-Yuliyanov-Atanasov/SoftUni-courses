import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int [] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> pesticides = new ArrayDeque<>();
        for (int i = n -1; i >= 0; i--) {
            pesticides.offer(input[i]);

        }

        int days = 0;
        while(true){
            int count = pesticides.size();
            ArrayDeque<Integer> helpQueue = new ArrayDeque<>();
            while (pesticides.size() > 1){
                int currentPlantPesticides = pesticides.poll();
                if(currentPlantPesticides <= pesticides.peek()){
                    helpQueue.offer(currentPlantPesticides);
                }
            }
            helpQueue.offer(pesticides.poll());
            if(helpQueue.size() == count){
                break;
            } else {
                days++;
                pesticides = helpQueue;
            }
        }
        System.out.println(days);
    }

}
