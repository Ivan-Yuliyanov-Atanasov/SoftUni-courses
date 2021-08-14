import java.util.Locale;
import java.util.Scanner;

public class FinalExamTask01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Done")){
            String [] tokens = inputLine.split(" ");
            String command= tokens [0];
            switch (command){
                case "Change":
                    String characterToReplace = tokens [1];
                    String replacement = tokens [2];
                    message = message.replace(characterToReplace,replacement);
                    System.out.println(message);
                    break;
                case "Includes":
                    String stringInclude = tokens [1];
                    if(message.contains(stringInclude)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String stringToEnd = tokens [1];
                    if(message.endsWith(stringToEnd)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "FindIndex":
                    char character = (tokens[1]).charAt(0);
                    int index = message.indexOf(character);
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    int endIndex = startIndex + length;
                    if(startIndex >= 0 && endIndex <= message.length()){
                        message = message.substring(startIndex,endIndex);
                        System.out.println(message);
                    }
                    break;
                case "Uppercase":
                    message = message.toUpperCase();
                    System.out.println(message);
                    break;
            }

            inputLine = scan.nextLine();
        }
    }
}
