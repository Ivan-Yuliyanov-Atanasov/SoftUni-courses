package farm;

import java.text.DecimalFormat;

public class Mammal extends Animal{
    protected String livingRegion;

    public Mammal(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    void makeSound() {

    }

    @Override
    public String toString() {
        DecimalFormat format  = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",this.getClass().getSimpleName(),animalName,format.format(animalWeight),livingRegion,foodEaten);
    }
}
