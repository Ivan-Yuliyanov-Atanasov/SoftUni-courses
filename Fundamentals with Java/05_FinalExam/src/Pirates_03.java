import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Integer>> cities = new TreeMap<>();
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Sail")) {
            String [] input = inputLine.split("\\|\\|");
            String city = input[0];
            int population = Integer.parseInt(input[1]);
            int gold = Integer.parseInt(input[2]);
            List<Integer> stats = new ArrayList<>();
            stats.add(population);
            stats.add(gold);
            if(!cities.containsKey(city)){
                cities.put(city,stats);
            } else {
                cities.get(city).set(0,cities.get(city).get(0) + population);
                cities.get(city).set(1,cities.get(city).get(1) + gold);
            }

            inputLine = scan.nextLine();

        }
        String input = scan.nextLine();
        while(!input.equals("End")){
            String [] tokens = input.split("=>");
            String command = tokens[0];
            String town = tokens[1];
            if(command.equals("Plunder")){
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);
                int leftPeople = cities.get(town).get(0) - people;
                int leftGold = cities.get(town).get(1) - gold;

                cities.get(town).set(0,leftPeople);
                cities.get(town).set(1,leftGold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                if(leftGold <= 0 || leftPeople <= 0 ) {
                    cities.remove(town);
                    System.out.printf("%s has been wiped off the map!%n",town);
                }

            } else {
                int gold = Integer.parseInt(tokens[2]);
                if(gold < 0){
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(town).set(1,cities.get(town).get(1) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold,town,cities.get(town).get(1));
                }

            }

            input = scan.nextLine();
        }
        if(!cities.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cities.size());
            cities.entrySet().stream()
                    .sorted((c1,c2)-> Integer.compare(c2.getValue().get(1),c1.getValue().get(1)))
                    .forEach(c-> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",c.getKey(),c.getValue().get(0),c.getValue().get(1)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
