package farm;

public class Zebra extends Mammal{
    public Zebra(String animalName,  Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    void makeSound(){
        System.out.println("Zs");
    }
}

