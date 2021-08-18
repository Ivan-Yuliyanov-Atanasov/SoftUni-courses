import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        while(!input.equals("End")){
            String [] tokens = input.split("\\s+");
            Vehicle vehicle = new Vehicle(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]));
            vehicles.add(vehicle);
            input = scan.nextLine();

        }
        input = scan.nextLine();
        while (!input.equals("Close the Catalogue")){
            String model = input;

            vehicles.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.print(vehicle.toString()));
            input = scan.nextLine();
        }
        double averageCarHorsepower = vehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .mapToDouble(Vehicle::getHorsepower)
                .average()
                .orElse(0);
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageCarHorsepower);
        double averageTruckHorsepower = vehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .mapToDouble(Vehicle::getHorsepower)
                .average()
                .orElse(0);
        System.out.printf("Trucks have average horsepower of: %.2f.",averageTruckHorsepower);

    }
    static class Vehicle{
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower){
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;


        }
        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }
        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }
        public String toString(){
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %s%n", getType().toUpperCase().charAt(0) + getType().substring(1),getModel(),getColor(),getHorsepower()  );
        }
    }
}
