import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Person> people = new LinkedHashMap<>();
        String inputLine = "";
        while(!(inputLine = scan.nextLine()).equals("End")){
            String [] tokens = inputLine.split(" ");
            String name = tokens[0];
            people.putIfAbsent(name,new Person(name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
            String command = tokens[1];
            switch (command){
                case "company":
                    people.get(name).setCompany(new Company(tokens[2],tokens[3],Double.parseDouble(tokens[4])));
                    break;
                case "car":
                    people.get(name).setCar(new Car(tokens[2],tokens[3]));
                    break;
                case "pokemon":
                    people.get(name).addPokemon(new Pokemon(tokens[2],tokens[3]));
                    break;
                case "parents":
                    people.get(name).addParent(new Parent(tokens[2],tokens[3]));
                    break;
                case "children":
                    people.get(name).addChild(new Child(tokens[2],tokens[3]));
                    break;
            }
        }
        String searchedPerson = scan.nextLine();
        if(people.containsKey(searchedPerson)){
            System.out.println(people.get(searchedPerson));
        }
    }
}
