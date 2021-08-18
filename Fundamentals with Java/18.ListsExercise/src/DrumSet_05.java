import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        List<Integer> drums = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < drums.size(); i++) {
            output.add(i,drums.get(i));

        }
        String input = scan.nextLine();
        while(!input.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < output.size(); i++) {
                int reducedDrumPower = output.get(i) - hitPower;
                if(reducedDrumPower > 0){
                    output.set(i,reducedDrumPower);
                } else {
                    int price = drums.get(i) * 3;
                    if(price <= money){
                        money -= price;
                        output.set(i,drums.get(i));
                    } else {
                        output.remove(i);
                        drums.remove(i);
                        i--;
                    }
                }

            }
            input = scan.nextLine();

        }
        for (Integer drum : output) {
            System.out.print(drum + " ");

        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",money);

    }
}
