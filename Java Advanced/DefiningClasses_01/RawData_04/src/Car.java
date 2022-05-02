public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tire [] tires;



    public Car(String [] tokens){
        this.model = tokens[0];
        this.engine = new Engine(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
        this.cargo = new Cargo(Integer.parseInt(tokens[3]),tokens[4]);
        this.tires = getArray(tokens);

    }

    private Tire[] getArray(String[] tokens) {
        Tire [] tires = new Tire[4];
        int i = 0;
        int j = 5;
        while (i < 4){
            Tire tire = new Tire(Double.parseDouble(tokens[j]),Integer.parseInt(tokens[j+1]));
            tires [i] = tire;
            i++;
            j += 2;
        }
        return tires;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    public Tire[] getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower(){
        return this.engine.getPower();
    }
}
