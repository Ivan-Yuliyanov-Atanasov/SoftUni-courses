import java.util.*;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> cars = new TreeMap<>();
        for (int i = 1; i <= n ; i++) {
            String [] input = scan.nextLine().split("\\|");
            String model = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            List<Integer> stats = new ArrayList<>();
            stats.add(mileage);
            stats.add(fuel);
            cars.put(model,stats);

        }
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Stop")){
            String [] tokens = inputLine.split(" : ");
            String command = tokens[0];
            String car = tokens [1];
            switch (command){
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if(fuel > cars.get(car).get(1)){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int newMileage = cars.get(car).get(0) + distance;
                        int newFuel = cars.get(car).get(1) - fuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car,distance,fuel);
                        if(newMileage >= 100000){
                            cars.remove(car);
                            System.out.printf("Time to sell the %s!%n",car);
                        } else {
                            List<Integer> newStats = new ArrayList<>();
                            newStats.add(newMileage);
                            newStats.add(newFuel);
                            cars.put(car,newStats);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(tokens[2]);
                    if(fuelToRefuel + cars.get(car).get(1) <= 75){
                        cars.get(car).set(1,fuelToRefuel + cars.get(car).get(1));
                        System.out.printf("%s refueled with %d liters%n",car,fuelToRefuel);
                    } else {
                        int diff = 75 - cars.get(car).get(1);
                        cars.get(car).set(1,75);
                        System.out.printf("%s refueled with %d liters%n",car,diff);
                    }
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(tokens[2]);
                    if(cars.get(car).get(0) - kilometres < 10000){
                        cars.get(car).set(0,10000);
                    } else {
                        cars.get(car).set(0,cars.get(car).get(0) - kilometres);
                        System.out.printf("%s mileage decreased by %d kilometers%n",car, kilometres);
                    }
                    break;
            }

            inputLine = scan.nextLine();
        }
        cars.entrySet().stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue().get(0),c1.getValue().get(0)))
                .forEach(c-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",c.getKey(),c.getValue().get(0),c.getValue().get(1)));
    }
}
