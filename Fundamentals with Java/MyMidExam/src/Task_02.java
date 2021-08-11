import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> biscuits = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("No More Money")){
            String [] tokens = inputLine.split(" ");
            String command = tokens [0];
            switch (command){
                case "Last":
                    String biscuitToAdd = tokens[1];
                    biscuits.add(biscuitToAdd);
                    break;
                case "OutOfStock":
                    String biscuitToReplace = tokens [1];
                    Collections.replaceAll(biscuits, biscuitToReplace, "None");
                    break;
                case "Required":
                    String biscuit = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if(index >= 0 && index < biscuits.size()){
                        if (!biscuits.get(index).equals("None")){
                            biscuits.set(index,biscuit);
                        }
                    }
                    break;
            }
            inputLine = scan.nextLine();
        }
        for (String biscuit : biscuits) {
            if(!biscuit.equals("None")){
                System.out.print(biscuit + " ");
            }

        }

    }
}
