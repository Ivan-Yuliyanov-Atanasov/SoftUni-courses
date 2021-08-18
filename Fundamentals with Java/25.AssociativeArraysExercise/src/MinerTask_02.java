import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")){
            int amount = Integer.parseInt(scan.nextLine());
            if(!resources.containsKey(input)){
                resources.put(input,amount);
            } else {
                resources.put(input,resources.get(input) + amount);
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());


        }
    }
}
