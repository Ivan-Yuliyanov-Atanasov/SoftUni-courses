import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Go Shopping!")){
            String [] tokens = inputLine.split(" ");
            String command = tokens[0];
            switch (command){
                case "Urgent":
                    String itemToAdd = tokens[1];
                    if(!groceries.contains(itemToAdd)){
                        groceries.add(0,itemToAdd);
                    }
                    break;
                case "Unnecessary":
                    String itemToRemove = tokens[1];
                    if(groceries.contains(itemToRemove)){
                        groceries.remove(itemToRemove);
                    }
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    if(groceries.contains(oldItem)){
                        int index = groceries.indexOf(oldItem);
                        groceries.set(index,newItem);
                    }
                    break;
                case "Rearrange":
                    String itemToRearrange = tokens[1];
                    if(groceries.contains(itemToRearrange)){
                        groceries.remove(itemToRearrange);
                        groceries.add(itemToRearrange);
                    }
            }
            inputLine =scan.nextLine();
        }
        System.out.println(groceries.toString().replaceAll("[\\[\\]]",""));
    }
}
