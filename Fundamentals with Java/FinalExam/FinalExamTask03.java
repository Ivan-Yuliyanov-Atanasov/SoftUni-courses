<<<<<<< HEAD
import java.util.*;

public class FinalExamTask03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> guests = new TreeMap<>();
        String inputLine = scan.nextLine();
        int unlikedMeals = 0;
        while (!inputLine.equals("Stop")){
            String [] tokens = inputLine.split("-");
            String command = tokens [0];
            String name = tokens [1];
            String meal = tokens [2];
            if(command.equals("Like")){
                if(!guests.containsKey(name)){
                    List<String> meals = new ArrayList<>();
                    meals.add(meal);
                    guests.put(name,meals);
                } else {
                    if(!guests.get(name).contains(meal)){
                        guests.get(name).add(meal);

                    }
                }
            } else {

                if(!guests.containsKey(name)){
                    System.out.printf("%s is not at the party.%n",name);
                } else {
                    if(!guests.get(name).contains(meal)){
                        System.out.printf("%s doesn\'t have the %s in his/her collection.%n",name,meal);
                    } else {
                        unlikedMeals ++;
                        guests.get(name).remove(meal);
                        System.out.printf("%s doesn\'t like the %s.%n",name,meal);

                    }
                }
            }
            inputLine = scan.nextLine();
        }
        guests.entrySet().stream()
                .sorted((g1,g2)-> Integer.compare(g2.getValue().size(),g1.getValue().size()))
                .forEach(g-> System.out.printf("%s: %s%n",g.getKey(),g.getValue().toString().replace("[","").replace("]","")));
        System.out.printf("Unliked meals: %d",unlikedMeals);
    }
}
=======
import java.util.*;

public class FinalExamTask03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> guests = new TreeMap<>();
        String inputLine = scan.nextLine();
        int unlikedMeals = 0;
        while (!inputLine.equals("Stop")){
            String [] tokens = inputLine.split("-");
            String command = tokens [0];
            String name = tokens [1];
            String meal = tokens [2];
            if(command.equals("Like")){
                if(!guests.containsKey(name)){
                    List<String> meals = new ArrayList<>();
                    meals.add(meal);
                    guests.put(name,meals);
                } else {
                    if(!guests.get(name).contains(meal)){
                        guests.get(name).add(meal);

                    }
                }
            } else {

                if(!guests.containsKey(name)){
                    System.out.printf("%s is not at the party.%n",name);
                } else {
                    if(!guests.get(name).contains(meal)){
                        System.out.printf("%s doesn\'t have the %s in his/her collection.%n",name,meal);
                    } else {
                        unlikedMeals ++;
                        guests.get(name).remove(meal);
                        System.out.printf("%s doesn\'t like the %s.%n",name,meal);

                    }
                }
            }
            inputLine = scan.nextLine();
        }
        guests.entrySet().stream()
                .sorted((g1,g2)-> Integer.compare(g2.getValue().size(),g1.getValue().size()))
                .forEach(g-> System.out.printf("%s: %s%n",g.getKey(),g.getValue().toString().replace("[","").replace("]","")));
        System.out.printf("Unliked meals: %d",unlikedMeals);
    }
}
>>>>>>> c177eeff4871c4c9df9483a787ac4dda37a20328
