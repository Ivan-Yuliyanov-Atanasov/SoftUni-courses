package farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        List<Mammal> animals = new ArrayList<>();
        while(!(inputLine = scanner.nextLine()).equals("End")){

                String [] animalTokens = inputLine.split(" ");
                String [] foodTokens = scanner.nextLine().split(" ");
                if(animalTokens[0].equals("Cat")){
                    Mammal animal = new Cat(animalTokens[1],Double.parseDouble(animalTokens[2]),animalTokens[3], animalTokens[4]);
                    animal.makeSound();
                    animal.eatFood(Integer.parseInt(foodTokens[1]));
                    animals.add(animal);
                } else if(animalTokens[0].equals("Tiger")){
                    Mammal animal = new Tiger(animalTokens[1],Double.parseDouble(animalTokens[2]),animalTokens[3]);
                    animal.makeSound();
                    if(foodTokens[0].equals("Vegetable")){
                        System.out.println("Tigers are not eating that type of food!");
                    } else {
                        animal.eatFood(Integer.parseInt(foodTokens[1]));
                    }
                    animals.add(animal);
                } else if((animalTokens[0].equals("Zebra"))){
                    Mammal animal = new Zebra(animalTokens[1],Double.parseDouble(animalTokens[2]),animalTokens[3]);
                    animal.makeSound();
                    if(foodTokens[0].equals("Meat")){
                        System.out.println("Zebras are not eating that type of food!");
                    } else {
                        animal.eatFood(Integer.parseInt(foodTokens[1]));
                    }
                    animals.add(animal);

                } else {
                    Mammal animal = new Mouse(animalTokens[1],Double.parseDouble(animalTokens[2]),animalTokens[3]);
                    animal.makeSound();
                    if(foodTokens[0].equals("Meat")){
                        System.out.println("Mice are not eating that type of food!");
                    } else {
                        animal.eatFood(Integer.parseInt(foodTokens[1]));
                    }
                    animals.add(animal);
                }

        }

            for (Mammal animal : animals) {
                System.out.println(animal);
            }


    }
}
