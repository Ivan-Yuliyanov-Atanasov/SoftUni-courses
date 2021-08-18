import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Craft!")){
            String [] tokens = inputLine.split("-");
            String command = tokens[0].trim();
            switch (command){

                case "Collect":
                    String itemToAdd = tokens[1].trim();
                    if(!items.contains(itemToAdd)){
                        items.add(itemToAdd);
                    }
                    break;
                case "Drop":
                    String itemToDrop = tokens[1].trim();
                    if(items.contains(itemToDrop)){
                        items.remove(itemToDrop);
                    }
                    break;
                case "Combine Items":
                    String item = tokens[1].trim();
                    String [] oldNewItems = item.split(":");
                    String oldItem = oldNewItems[0];
                    String newItem = oldNewItems[1];
                    if(items.contains(oldItem)){
                        int index = items.indexOf(oldItem);
                        items.add((index + 1),newItem);
                    }
                    break;
                case "Renew":
                    String itemToRenew = tokens[1].trim();
                    if(items.contains(itemToRenew)){
                        items.remove(itemToRenew);
                        items.add(itemToRenew);
                    }
                    break;
            }
            inputLine = scan.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\]]",""));
    }
}
