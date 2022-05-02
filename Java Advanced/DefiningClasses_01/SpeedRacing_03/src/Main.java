import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(fuelAmount, fuelPerKm);
            cars.put(model,car);

        }
        String inputLine = "";
        while(!(inputLine = scan.nextLine()).equals("End")){
            String [] tokens = inputLine.split(" ");
            String model = tokens[1];
            int kmToTravel = Integer.parseInt(tokens[2]);

            if(cars.get(model).haveFuel(kmToTravel)){
                cars.get(model).setDistanceTravelled(cars.get(model).getDistanceTravelled() + kmToTravel);
                cars.get(model).setFuelAmount(cars.get(model).getFuelAmount() - kmToTravel * cars.get(model).getFuelPerKm());
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        cars.entrySet().stream()
                .forEach(c -> System.out.printf("%s %.02f %.00f%n",c.getKey(),c.getValue().getFuelAmount(),c.getValue().getDistanceTravelled()));

    }
}
