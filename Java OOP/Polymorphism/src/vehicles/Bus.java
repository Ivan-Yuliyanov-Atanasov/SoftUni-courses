package vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    public Bus(double fuel, double fuelConsumption, int tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometres){

        if(kilometres * (this.fuelConsumption + 1.4) <= this.fuel){
            this.fuel -= (kilometres * (this.fuelConsumption + 1.4));
            DecimalFormat format  = new DecimalFormat("##.##");
            System.out.printf("%s travelled %s km%n",this.getClass().getSimpleName(),format.format(kilometres));

        } else {
            System.out.printf("%s needs refueling%n",this.getClass().getSimpleName());
        }

    }


    public void driveEmpty(double kilometres){

        if(kilometres * this.fuelConsumption <= this.fuel){
            this.fuel -= kilometres * this.fuelConsumption;
            DecimalFormat format  = new DecimalFormat("##.##");
            System.out.printf("%s travelled %s km%n",this.getClass().getSimpleName(),format.format(kilometres));

        } else {
            System.out.printf("%s needs refueling%n",this.getClass().getSimpleName());
        }

    }
}
