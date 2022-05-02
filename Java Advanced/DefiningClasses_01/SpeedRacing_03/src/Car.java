public class Car {
    double fuelAmount;
    double fuelPerKm;
    double distanceTravelled;

    public Car(double fuelAmount, double fuelPerKm) {
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
        this.distanceTravelled = 0;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public boolean haveFuel(int kmToTravel){
        return this.fuelPerKm * kmToTravel <= this.fuelAmount;
    }





}

