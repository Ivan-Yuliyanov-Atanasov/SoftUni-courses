import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Person person = new Person (tokens[0], Integer.parseInt(tokens[1]));
            persons.add(person);
        }
        persons.stream()
        .filter(person -> person.getAge() > 30)
        .sorted((p1,p2)-> p1.getName().compareTo(p2.getName()))
        .forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

    }
    static class Person {
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;

        }

        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
    }
}
