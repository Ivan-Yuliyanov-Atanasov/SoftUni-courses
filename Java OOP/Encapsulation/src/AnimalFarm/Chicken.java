package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private double calculateProductPerDay(){
        double productPerDay = -1;
        if(this.age >= 0 && this.age < 6){
            productPerDay = 2;
        } else if(this.age >= 6 && this.age < 12){
            productPerDay = 1;
        } else if(this.age >= 12 && this.age < 15){
            productPerDay = 0.75;
        }
        return productPerDay;
    }
    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    public void setName(String name) {
        if(name == null || name.isEmpty() || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.02f eggs per day.",name, age, productPerDay());
    }
}
