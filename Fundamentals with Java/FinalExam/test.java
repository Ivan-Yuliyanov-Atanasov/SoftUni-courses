import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Integer> animals = new TreeMap<>();
        Map<String, List<String>> areas = new TreeMap<>();

        String inputLine = scan.nextLine();
        while(!inputLine.equals("EndDay")){
            String [] tokens = inputLine.split(": ");
            String command = tokens[0];
            String [] inputParts = tokens [1].split("-");
            String animalName = inputParts[0];
            if(command.equals("Add")){

                int neededFood = Integer.parseInt(inputParts[1]);
                String area = inputParts [2];
                if(!animals.containsKey(animalName)){
                    animals.put(animalName,neededFood);
                    if(!areas.containsKey(area)){
                        areas.put(area,new ArrayList<>());
                        areas.get(area).add(animalName);
                    } else {
                        if(!areas.get(area).contains(animalName)){
                            areas.get(area).add(animalName);
                        }
                    }
                } else {
                    animals.put(animalName,animals.get(animalName) + neededFood);
                }
            } else {
                int food = Integer.parseInt(inputParts[1]);
                if(animals.containsKey(animalName)){
                    int diff = animals.get(animalName) - food;
                    if(diff <= 0){
                        animals.remove(animalName);
                        for (Map.Entry<String,List<String>> area : areas.entrySet()) {
                            if(area.getValue().contains(animalName)){
                                area.getValue().remove(animalName);
                            }

                        }
                        System.out.printf("%s was successfully fed%n",animalName);
                    } else {
                        animals.put(animalName,animals.get(animalName) - food);
                    }
                }
            }
            inputLine = scan.nextLine();
        }
        System.out.println("Animals:");
        animals.entrySet().stream()
                .sorted((a1,a2)-> Integer.compare(a2.getValue(),a1.getValue()))
                .forEach(a-> System.out.printf("%s -> %dg%n",a.getKey(),a.getValue()));
        System.out.printf("Areas with hungry animals:%n");
        areas.entrySet().stream()
                .sorted((a1,a2)-> Integer.compare(a2.getValue().size(),a1.getValue().size()))
                .filter(a->a.getValue().size()>0)
                .forEach(a-> System.out.printf("%s: %d%n",a.getKey(),a.getValue().size()));

    }

}
