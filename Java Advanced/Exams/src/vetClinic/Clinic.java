package vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet currentPet : data) {
            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)) {
                return currentPet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public Pet getOldestPet() {
        List<Pet> sortedByAge = this.data.stream().sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge())).collect(Collectors.toList());
        return sortedByAge.get(0);

    }

    public String getStatistics(){
        StringBuilder output = new StringBuilder();
        output.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            String format = String.format("%s %s",pet.getName(),pet.getOwner());
            output.append(format).append(System.lineSeparator());

        }
        return output.toString();
    }

}
