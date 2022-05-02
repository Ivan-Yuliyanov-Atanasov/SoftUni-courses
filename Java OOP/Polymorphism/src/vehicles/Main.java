package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] carInfo = scanner.nextLine().split(" ");
        String [] truckInfo = scanner.nextLine().split(" ");
        String [] busInfo = scanner.nextLine().split(" ");

        Car car = new Car(Double.parseDouble(carInfo[1]),Double.parseDouble(carInfo[2]),Integer.parseInt(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),Double.parseDouble(truckInfo[2]),Integer.parseInt(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]),Double.parseDouble(busInfo[2]),Integer.parseInt(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String [] tokens = scanner.nextLine().split(" ");
            if(tokens[0].equals("Drive")){
                if(tokens[1].equals("Car")){
                    car.drive(Double.parseDouble(tokens[2]));
                } else if (tokens[1].equals("Truck")){
                    truck.drive(Double.parseDouble(tokens[2]));
                } else {
                    bus.drive(Double.parseDouble(tokens[2]));
                }
            } else if (tokens[0].equals("DriveEmpty")){
                bus.driveEmpty(Double.parseDouble(tokens[2]));
            }
            else if (tokens[0].equals("Refuel")){
                if(tokens[1].equals("Car")){
                    try {
                        car.refuel(Double.parseDouble(tokens[2]));
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }

                } else if (tokens[1].equals("Truck")){
                    try {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }

                } else {
                    try {
                        bus.refuel(Double.parseDouble(tokens[2]));
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }


        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
