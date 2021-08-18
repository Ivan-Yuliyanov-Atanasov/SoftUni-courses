import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String input = scan.nextLine();

        while(!input.equals("End")){
            String[]tokens = input.split(" ");
            Person person = new Person(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
            persons.add(person);
            input = scan.nextLine();
        }
        persons.stream()
                .sorted((p1,p2)-> Integer.compare(p1.getAge(),p2.getAge()))
                .forEach(person -> System.out.printf("%s with ID: %s is %d years old.%n",person.getFirstName(),person.getID(),person.getAge()));
    }
    static class Person {
        String firstName;
        String ID;
        int age;

        public Person(String firstName, String ID, int age) {
            this.firstName = firstName;
            this.ID = ID;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getID() {
            return ID;
        }

        public int getAge() {
            return age;
        }
    }
}
