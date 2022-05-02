package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        if(name.trim().length() > 15 || name.trim().length() < 1){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name.trim();
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");

        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping){

        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double toppingCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        return toppingCalories + dough.calculateCalories();
    }
}
