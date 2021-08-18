import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> chest = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Yohoho!")){
            String [] tokens = inputLine.split(" ");
            String command = tokens[0];
            switch (command){
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String item = tokens[i];
                        if(!chest.contains(item)){
                            chest.add(0,item);
                        }
                    }
                break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if(index >= 0 && index < chest.size()){
                        String loot = chest.get(index);
                        chest.remove(index);
                        chest.add(loot);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    int length = Math.min(count, chest.size());
                    int i = 0;
                    while (i < length){
                        if (i == length - 1){
                            System.out.print(chest.get(chest.size() - length + i));
                            System.out.println();
                        } else {
                            System.out.print(chest.get(chest.size() - length + i) + ", ");
                        }

                        chest.remove(chest.size() - length + i);
                        i++;

                    }
                    break;

            }
            inputLine = scan.nextLine();
        }
        if(chest.isEmpty()){
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (String loot : chest) {
                sum += (loot.length());

            }
            System.out.printf("Average treasure gain: %.2f pirate credits.",sum/chest.size());
        }


    }
}
