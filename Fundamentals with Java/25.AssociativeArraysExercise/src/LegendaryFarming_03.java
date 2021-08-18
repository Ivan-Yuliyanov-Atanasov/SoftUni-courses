import java.util.*;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new HashMap<>();
        boolean isObtained = false;
        while(!isObtained){
            String [] input = scan.nextLine().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String item = input[i+1].toLowerCase();

                if(keyMaterials.containsKey(item)){
                    addToMap(keyMaterials, item, quantity);
                    if(keyMaterials.get(item) >= 250){
                        switch (item){
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        isObtained = true;
                        keyMaterials.put(item, keyMaterials.get(item) - 250);
                        break;
                    }
                } else {
                    addToMap(junk, item, quantity);
                }

            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((i1, i2) ->{
                    int result = i2.getValue().compareTo(i1.getValue());
                    if(result == 0){
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;})
                .forEach(i-> System.out.println(String.format("%s: %d",i.getKey(),i.getValue())));
        junk.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i-> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));

    }

    private static void addToMap(Map<String, Integer> map, String item, int quantity) {
        map.putIfAbsent(item,0);
        map.put(item,map.get(item) + quantity);
    }
}
