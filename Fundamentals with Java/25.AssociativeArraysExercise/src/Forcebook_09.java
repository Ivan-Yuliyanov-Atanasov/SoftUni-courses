import java.util.*;

public class Forcebook_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String,String> users = new LinkedHashMap<>();
        TreeMap<String, List<String>> forceSides= new TreeMap<>();
        String inputLine = scan.nextLine();
        String forceSide;
        String forceUser;
        while (!inputLine.equals("Lumpawaroo")){
            if(inputLine.contains(" | ")){
                forceSide = (inputLine.split(" \\| "))[0];
                forceUser = (inputLine.split(" \\| "))[1];
                if(!users.containsKey(forceUser)){
                    users.put(forceUser,forceSide);
                    forceSides.putIfAbsent(forceSide,new ArrayList<>());
                    forceSides.get(forceSide).add(forceUser);
                }
            } else if (inputLine.contains(" -> ")){
                forceSide = (inputLine.split(" -> "))[1];
                forceUser = (inputLine.split(" -> "))[0];
                if(users.containsKey(forceUser)){
                    String oldSide = users.get(forceUser);
                    forceSides.get(oldSide).remove(forceUser);
                }
                users.put(forceUser,forceSide);
                forceSides.putIfAbsent(forceSide,new ArrayList<>());
                forceSides.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n",forceUser,forceSide);
            }
            inputLine = scan.nextLine();
        }
        forceSides.entrySet().stream()
                .filter(e->e.getValue().size() > 0)
                .sorted((e1,e2)->Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n",e.getKey(),e.getValue().size());
                            e.getValue().stream()
                                    .sorted(String::compareTo)
                                    .forEach(n-> System.out.printf("! %s%n",n));
                });

    }
}
