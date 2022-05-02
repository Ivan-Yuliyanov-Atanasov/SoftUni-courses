import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Car car = new Car(tokens);
            cars.add(car);

        }
        String command = scan.nextLine();
        if(command.equals("fragile")){
            cars.stream()
                    .filter(c -> c.getCargoType().equals(command))
                    .filter(c -> {
                        for (int i = 0; i < 4; i++) {
                            if(c.getTires()[i].getPressure() < 1){
                                return true;

                            }
                        }
                        return false;
                    })
                    .forEach(c -> System.out.println(c.getModel()));

        } else {
            cars.stream()
                    .filter(c -> c.getCargoType().equals(command))
                    .filter(c -> c.getEnginePower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));

        }

    }
}
