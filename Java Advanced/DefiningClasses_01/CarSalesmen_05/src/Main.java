import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Engine engine = new Engine(tokens);
            engines.add(engine);

        }
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Car car = new Car(tokens);
            cars.add(car);

        }
        for (Car car : cars) {
            for (Engine engine : engines) {
                if(car.getEngineModel().equals(engine.getModel())){
                    System.out.printf("%s:%n",car.getModel());
                    System.out.printf("%s:%n",car.getEngineModel());
                    System.out.printf("Power: %s%n",engine.getPower());
                    System.out.printf("Displacement: %s%n",engine.getDisplacement());
                    System.out.printf("Efficiency: %s%n",engine.getEfficiency());
                    System.out.printf("Weight: %s%n",car.getWeight());
                    System.out.printf("Color: %s%n",car.getColor());
                }

            }

        }
    }
}
