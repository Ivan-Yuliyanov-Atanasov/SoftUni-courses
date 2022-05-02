package parking;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(c -> (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)));
    }

    public Car getCar(String manufacturer, String model) {
        for (Car currentCar : data) {
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                return currentCar;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public Car getLatestCar() {
        List<Car> sortedByAge = this.data.stream().sorted((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear())).collect(Collectors.toList());
        if (sortedByAge.isEmpty()) {
            return null;
        }
        return sortedByAge.get(0);

    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The cars are parked in %s:",this.type)).append(System.lineSeparator());
        for (Car car : data) {

            output.append(car).append(System.lineSeparator());

        }
        return output.toString();
    }
}
