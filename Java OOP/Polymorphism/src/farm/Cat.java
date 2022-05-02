package farm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound(){
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat format  = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]",this.getClass().getSimpleName(),animalName,breed,format.format(animalWeight),livingRegion,foodEaten);
    }

}
