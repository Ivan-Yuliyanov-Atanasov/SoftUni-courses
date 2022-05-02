package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split(" ");
        List<Lights> data = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            Lights currentLight = new Lights(tokens[i]);
            data.add(currentLight);

        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < data.size(); j++) {
                changeLightColor(data.get(j));
                System.out.print(data.get(j).getColor() + " ");
            }
            System.out.println();

        }
    }

    private static void changeLightColor(Lights light) {
        String currentColor = light.getColor();
        if(currentColor.equals("RED") ){
            light.setColor("GREEN");
        } else if(currentColor.equals("GREEN")){
            light.setColor("YELLOW");
        } else {
            light.setColor("RED");
        }
    }
}
