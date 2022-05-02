package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<Rabbit>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Rabbit rabbit){
        if(this.data.size() < this.capacity){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        return data.removeIf(r -> r.getName().equals(name));
    }
    public int count(){
        return this.data.size();
    }
    public void removeSpecies(String species){

        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }
    public Rabbit sellRabbit(String name){
        Rabbit currentRabbit = null;
        for (Rabbit rabbit : this.data) {
            if(rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                currentRabbit = rabbit;
                break;

            }

        }
        return currentRabbit;

    }
    public ArrayList<Rabbit> sellRabbitBySpecies(String species){

        ArrayList<Rabbit> soldRabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if(rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                soldRabbits.add(rabbit);
            }


        }
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
        return soldRabbits;
    }
    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("Rabbits available at %s:",this.name));
        report.append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if(rabbit.isAvailable()){
                report.append(rabbit);
                report.append(System.lineSeparator());
            }

        }
        return report.toString();
    }
}
