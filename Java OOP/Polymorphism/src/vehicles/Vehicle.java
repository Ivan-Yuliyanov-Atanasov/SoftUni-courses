package vehicles;

import java.text.DecimalFormat;

public abstract class  Vehicle {
    protected double fuel;
    protected double fuelConsumption;
    protected int tankCapacity;

    public Vehicle(double fuel, double fuelConsumption, int tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.fuelConsumption = fuelConsumption;

    }

    protected void refuel(double fuel){
        if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if(fuel + this.fuel > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuel += fuel;

    }

    public void setFuel(double fuel) {
        if(fuel <= 0 || fuel > tankCapacity){
            this.fuel = 0;
        }
        this.fuel = fuel;
    }

    public void drive(double kilometres){

        if(kilometres * this.fuelConsumption <= this.fuel){
            this.fuel -= kilometres * this.fuelConsumption;
            DecimalFormat format  = new DecimalFormat("##.##");
            System.out.printf("%s travelled %s km%n",this.getClass().getSimpleName(),format.format(kilometres));

        } else {
            System.out.printf("%s needs refueling%n",this.getClass().getSimpleName());
        }

    }

    @Override
    public String toString() {
        return String.format("%s: %.02f",this.getClass().getSimpleName(), this.fuel);
    }
}
