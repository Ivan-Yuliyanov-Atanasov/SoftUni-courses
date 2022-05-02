package ComparingObjects_05;

public class Person implements Comparable<Person>{
    String name;
    int age;
    String town;

    public Person(String [] tokens) {
        this.name = tokens [0];
        this.age = Integer.parseInt(tokens [1]);
        this.town = tokens [2];
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.name);
        if(result == 0){
            result = Integer.compare(this.age,other.age);
            if(result == 0) {
                result = this.town.compareTo(other.town);
            }
        }
        return  result;
    }
}
