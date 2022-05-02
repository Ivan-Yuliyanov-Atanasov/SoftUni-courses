package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(3);
    }

    @Override
    public void eat() {
        int newSize = this.getSize() + 3;
        this.setSize(newSize);
    }
}
