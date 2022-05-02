package farm;

public class Tiger extends Felime{

    private String livingRegion;

    public Tiger(String animalName,  Double animalWeight, String livingRegion) {
        super(animalName,  animalWeight, livingRegion);
    }

    @Override
    void makeSound(){
        System.out.println("ROAAR!!!");
    }
}
