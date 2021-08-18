import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> plants = new HashMap<>();
        Map<String, ArrayList<Double>> ratings = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            ratings.putIfAbsent(plant,new ArrayList<>());
            plants.putIfAbsent(plant,rarity);
            plants.put(plant,rarity);

        }
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Exhibition")){
            String [] tokens = inputLine.split(": ");
            String command = tokens[0];
            String name = (tokens[1].split(" - "))[0];
            if(!plants.containsKey(name)){
                System.out.println("error");
                inputLine = scan.nextLine();
                continue;
            }
            switch (command){
                case "Reset":
                    String plantToReset = tokens[1];
//                    for (int i = 0; i < ratings.get(plantToReset).size(); i++) {
//                        ratings.get(plantToReset).remove(0);


//                    }
                    ratings.get(plantToReset).clear();
                    break;
                case "Rate":
                    String plantToRate = (tokens[1].split(" - "))[0];
                    double rating = Double.parseDouble((tokens[1].split(" - "))[1]);
                    ratings.get(plantToRate).add(rating);
                    break;
                case "Update":
                    String plantToUpdate = (tokens[1].split(" - "))[0];
                    int newRarity = Integer.parseInt((tokens[1].split(" - "))[1]);
                    plants.put(plantToUpdate,newRarity);
                    break;
                default:
                    System.out.println("error");

            }
            inputLine = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> ratings.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                        ratings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

//        plants.entrySet().stream()
//                .sorted((s1,s2)->{
//                    int result = s2.getValue() - s1.getValue();
//                    if(result == 0){
//                        double firstNum = ratings.get(s1.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0);
//                        double secondNum = ratings.get(s2.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0);
//                        result = Double.compare(secondNum,firstNum);
//                    }
//                    return result;
//                })
//////                .sorted((s1,s2)->{
//////                    double firstNum = ratings.get(s1.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0);
//////                    double secondNum = ratings.get(s2.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0);
//////                    return Double.compare(secondNum,firstNum);
//////                })
//////                .sorted((s1,s2)->Integer.compare(s2.getValue(),s1.getValue()))
//                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
//                        e.getKey(),e.getValue(),ratings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0)));
    }
}
