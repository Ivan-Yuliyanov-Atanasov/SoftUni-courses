import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftuniParking_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> register = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String command = tokens[0];
            String key = tokens[1];

            switch (command){
                case "register":
                    String value = tokens[2];
                    if(!register.containsKey(key)){
                        register.put(key,value);
                        System.out.printf("%s registered %s successfully%n",key,value);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n",value);
                    }
                    break;
                case "unregister":
                    if(!register.containsKey(key)){
                        System.out.printf("ERROR: user %s not found%n",key);
                    } else {
                        register.remove(key);
                        System.out.printf("%s unregistered successfully%n",key);
                    }
                    break;
            }

        }
        for (Map.Entry<String, String> entry : register.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
