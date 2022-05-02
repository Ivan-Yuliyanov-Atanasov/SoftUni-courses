package pizza;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce") ){
            throw new IllegalArgumentException("Cannot place " + this.toppingType +  " on top of your pizza.");

        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        double modifier = 0.00;

         if (this.toppingType.equals("Meat")){
            modifier = 1.20;
        } else if (this.toppingType.equals("Veggies")) {
             modifier = 0.80;
         } else if(this.toppingType.equals("Cheese")){
             modifier = 1.10;
        } else {
            modifier = 0.9;
        }
        return this.weight * 2 * modifier;
    }
}
