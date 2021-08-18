import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String inputLine = scan.nextLine();
        int counter = 0;
        while (!inputLine.equals("End")){
            int index = Integer.parseInt(inputLine);
            if(index >= 0 && index < targets.length && targets[index] != -1){
                int currentTargetValue = targets[index];
                targets[index] = -1;
                counter ++;
                for (int i = 0; i < targets.length; i++) {
                    if(targets[i] != -1){
                        if(targets[i] > currentTargetValue){
                            targets[i] -= currentTargetValue;
                        } else {
                            targets[i] += currentTargetValue;
                        }
                    }

                }

            }
            inputLine = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",counter);
        for (int target : targets) {
            System.out.print(target + " ");

        }
    }
}
