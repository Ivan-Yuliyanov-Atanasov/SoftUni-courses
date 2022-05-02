public class Car {
    String type;
    String speed;

    public Car(String type, String speed) {
        this.type = type;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.type,this.speed);
    }
}
