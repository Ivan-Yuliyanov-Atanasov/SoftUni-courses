package vehicles;

public class Truck extends Vehicle{

    public Truck(double fuel, double fuelConsumption, int tankCapacity) {
        super(fuel, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double fuel){
        super.refuel(fuel * 0.95);
    }
}
