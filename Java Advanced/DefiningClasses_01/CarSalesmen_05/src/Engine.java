public class Engine {

    String model;
    int power;
    String displacement;
    String efficiency;

    public Engine(String [] tokens){
        this.setModel(tokens);
        this.setPower(tokens);
        this.setDisplacementAndEfficiency(tokens);
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    private void setDisplacementAndEfficiency(String[] tokens) {
        if(tokens.length == 4){
            this.displacement = tokens[2];
            this.efficiency = tokens [3];
        } else if (tokens.length == 3){
            try {
                int x = Integer.parseInt(tokens[2]);
                this.displacement = tokens[2];
                this.efficiency = "n/a";
            } catch (Exception e){
                this.displacement = "n/a";
                this.efficiency = tokens [2];
            }
        } else if (tokens.length == 2){
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }
    }

    public String getEngineModel() {
        return model;
    }

    private void setPower(String[] tokens) {
        this.power = Integer.parseInt(tokens[1]);
    }

    public void setModel(String [] tokens){
        this.model = tokens[0];
    }

}
