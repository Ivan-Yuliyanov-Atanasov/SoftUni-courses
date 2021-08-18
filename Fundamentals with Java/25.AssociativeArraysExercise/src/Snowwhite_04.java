import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Integer> dwarves = new LinkedHashMap<>();
        Map<String,Integer> count = new LinkedHashMap<>();

        String inputLine = scan.nextLine();
        while (!inputLine.equals("Once upon a time")){

            String [] tokens = inputLine.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            String colorName = color + ":" + name;
            int physics = Integer.parseInt(tokens[2]);
            if(!dwarves.containsKey(colorName)){
                dwarves.put(colorName,physics);
                if(!count.containsKey(color)){
                    count.put(color,1);
                } else {
                    count.put(color,count.get(color) + 1);
                }
            } else {
                if (dwarves.get(colorName) < physics){
                    dwarves.put(colorName,physics);
                }
            }


            inputLine = scan.nextLine();
        }
        dwarves.entrySet().stream()
                .sorted((d1,d2)->{
                    int result = d2.getValue() - d1.getValue();
                    if (result == 0){
                        String d1Color = (d1.getKey().split(":"))[0];
                        String d2Color = (d2.getKey().split(":"))[0];
                        int d1Size = count.get(d1Color);
                        int d2Size = count.get(d2Color);
                        result = d2Size - d1Size;
                    }
                    return  result;
                })
                .forEach(d -> {
                    String color = (d.getKey().split(":"))[0];
                    String name = (d.getKey().split(":"))[1];
                    System.out.printf("(%s) %s <-> %d%n",color,name,d.getValue());
                });


    }
}
