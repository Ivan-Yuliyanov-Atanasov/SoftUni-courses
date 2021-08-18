import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTheTarget_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("End")){
            String[] tokens = inputLine.split(" ");
            String commmand = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            switch (commmand){
                case "Shoot":
                    int power = Integer.parseInt(tokens[2]);
                    if(index >= 0 && index < targets.size()){
                        if(targets.get(index) - power <= 0){
                            targets.remove(index);
                        } else {
                            targets.set(index,targets.get(index) - power);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(tokens[2]);
                    if(index >= 0 && index < targets.size()){
                        targets.add(index,value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(tokens[2]);
                    if((index - radius) >= 0 && (index + radius) < targets.size()){
                       int i = 0;
                       while(i < 2*radius + 1){

                           targets.remove(index - radius);
                           i++;

                       }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;

            }
            inputLine = scan.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if(i == targets.size() - 1){
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }

        }
    }
}
