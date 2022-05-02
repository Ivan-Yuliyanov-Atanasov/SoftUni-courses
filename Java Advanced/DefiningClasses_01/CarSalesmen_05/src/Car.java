public class Car {
    String model;
    String engineModel;
    String weight;
    String color;

    public Car(String [] tokens){
        this.setModel(tokens);
        this.setEngineModel(tokens);
        this.setWeightAndColor(tokens);
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    private void setWeightAndColor(String[] tokens) {
        if(tokens.length == 4){
            this.weight = tokens[2];
            this.color = tokens [3];
        } else if (tokens.length == 3){
            try {
                int x = Integer.parseInt(tokens[2]);
                this.weight = tokens[2];
                this.color = "n/a";
            } catch (Exception e){
                this.weight = "n/a";
                this.color = tokens [2];
            }
        } else if(tokens.length == 2) {
            this.weight = "n/a";
            this.color = "n/a";
        }
    }

    private void setEngineModel(String[] tokens) {
        this.engineModel = tokens[1];
    }

    public void setModel(String [] tokens){
        this.model = tokens[0];
    }
}
