package farm;

public abstract class Animal {

    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected Integer foodEaten;

    public Animal(String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    abstract void makeSound();

    protected void eatFood(int food){
        this.foodEaten += food;
    }


}
