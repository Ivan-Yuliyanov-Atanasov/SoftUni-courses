import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("search")){
            String [] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.put(name,number);
        }
        while(!(input = scan.nextLine()).equals("stop")){
            if(phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n",input);
            }
        }


    }
}
