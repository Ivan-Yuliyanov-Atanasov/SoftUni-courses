package christmas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count(){
        return this.data.size();
    }
    public void add(Present present){
        if(this.data.size() < this.capacity){
            this.data.add(present);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(p->p.getName().equals(name));
    }
    public Present getPresent(String name){
        return this.data.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
    public Present heaviestPresent(){
        List<Present> sortedByWeight = this.data.stream().sorted((p1,p2)-> Double.compare(p2.getWeight(),p1.getWeight())).collect(Collectors.toList());
        return sortedByWeight.get(0);
    }
    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s bag contains:",this.color));
        report.append(System.lineSeparator());
        for (Present present : data) {
            report.append(present);
            report.append(System.lineSeparator());
        }
        return report.toString();
    }
}
