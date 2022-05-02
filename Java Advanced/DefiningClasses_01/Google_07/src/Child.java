public class Child {
    String name;
    String birthDay;

    public Child(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.name,this.birthDay);
    }
}
