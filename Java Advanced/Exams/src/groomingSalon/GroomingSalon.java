package groomingSalon;
import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet){
        if(this.data.size() < this.capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }
    public Pet  getPet(String name, String owner){
        Pet pet = null;
        for (Pet currentPet : data) {
            if(currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)){
                pet = currentPet;
            }
        }
        return pet;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("The grooming salon has the following clients:"));
        report.append(System.lineSeparator());
        for (Pet pet : data) {

            report.append(String.format("%s %s",pet.getName(),pet.getOwner()));
            report.append(System.lineSeparator());
        }

        return report.toString();
    }

}
