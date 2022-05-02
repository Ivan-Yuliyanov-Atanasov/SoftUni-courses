import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String inputLine = "";


        while(!(inputLine = scan.nextLine()).equals("Party!")){
            String [] tokens = inputLine.split("\\s+");
            String command = tokens[0];
            if(command.equals("Remove")){
               removeGuest(names,tokens[1],tokens[2]);
            } else {
                addGuest(names,tokens[1],tokens[2]);

            }
        }
        if(names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            String toPrint = names.stream().collect(Collectors.joining(", "));
            System.out.println(toPrint + " are going to the party!");

        }
    }

    private static void addGuest(List<String> names, String command, String param) {
        int listSize = names.size();
        if(command.equals("StartsWith")){
            for (int i = 0; i < listSize; i++) {
                if(names.get(i).startsWith(param)){
                    names.add(names.get(i));

                }
            }
        } else if (command.equals("EndsWith")){
            for (int i = 0; i < listSize; i++) {
                if (names.get(i).endsWith(param)) {
                    names.add(names.get(i));

                }
            }
        } else {
            for (int i = 0; i < listSize; i++) {
                if (names.get(i).length() == Integer.parseInt(param)) {
                    names.add(names.get(i));

                }
            }
        }
    }

    private static void removeGuest(List<String> names, String command, String param) {

        if(command.equals("StartsWith")){
            for (int i = 0; i < names.size(); i++) {
                if(names.get(i).startsWith(param)){
                    names.remove(names.get(i));
                    i--;
                }
            }
        } else if (command.equals("EndsWith")){
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).endsWith(param)) {
                    names.remove(names.get(i));
                    i--;
                }
            }
        } else {
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).length() == Integer.parseInt(param)) {
                    names.remove(names.get(i));
                    i--;
                }
            }
        }
    }
}
