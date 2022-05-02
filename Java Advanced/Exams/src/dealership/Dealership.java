package dealership;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public String name;
    public int capacity;
    List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(this.data.size() < this.capacity){
            this.data.add(car);
        }
    }
    public int getCount(){
        return this.data.size();
    }
    public Car getCar(String manufacturer, String model){
        return this.data.stream().filter(c->c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().orElse(null);
    }
    public Car getLatestCar(){
        List<Car> sortedByYear =  this.data.stream().sorted((c1,c2) -> Integer.compare(c2.getYear(), c1.getYear())).collect(Collectors.toList());
        if(!sortedByYear.isEmpty()){
            return sortedByYear.get(0);
        }
        return null;
    }
    public boolean buy(String manufacturer, String model){
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public String getStatistics(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("The cars are in a car dealership %s:",name));
        report.append(System.lineSeparator());
        for (Car car : data) {

            report.append(car);
            report.append(System.lineSeparator());
        }

        return report.toString();
    }


}
