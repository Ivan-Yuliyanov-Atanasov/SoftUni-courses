package vehicles;

public class Car extends Vehicle{

    public Car(double fuel, double fuelConsumption, int tankCapacity) {
        super(fuel, fuelConsumption + 0.9, tankCapacity);
    }
}
