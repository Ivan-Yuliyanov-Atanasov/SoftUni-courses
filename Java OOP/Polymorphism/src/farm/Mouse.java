package farm;

public class Mouse extends Mammal{
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound(){
        System.out.println("SQUEEEAAAK!");
    }
}
