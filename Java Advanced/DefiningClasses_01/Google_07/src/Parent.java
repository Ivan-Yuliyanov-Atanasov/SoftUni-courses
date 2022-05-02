public class Parent {
    String name;
    String birthDay;

    public Parent(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.name,this.birthDay);
    }
}
