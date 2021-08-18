import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Reveal")){
            String [] tokens = inputLine.split(":\\|:");
            String command = tokens[0];
            boolean isError = false;
            switch (command){
                case "InsertSpace":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String fullMessage = message.toString();
                    String firstPart = fullMessage.substring(0,indexToInsert);
                    String secondPart = fullMessage.substring(indexToInsert);
                    String joinedMessage = firstPart + " " + secondPart;
                    message.setLength(0);
                    message.append(joinedMessage);
                    break;
                case "ChangeAll":
                    String stringToReplace = tokens[1];
                    String replacementString = tokens[2];
                    String newMessage = message.toString().replace(stringToReplace,replacementString);
                    message.setLength(0);
                    message.append(newMessage);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if(!message.toString().contains(substring)){
                        isError = true;
                        System.out.println("error");
                    } else {
                       String reversedString = reverseString(substring);
                       int startIndex = message.indexOf(substring);
                       int endIndex = startIndex + substring.length();
                       message.delete(startIndex, endIndex);
                       message.append(reversedString);
                    }
                    break;

            }
            if(!isError){
                System.out.println(message.toString());
            }

            inputLine = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s",message.toString());
    }

    private static String reverseString(String substring) {
        StringBuilder reversedMessage= new StringBuilder();
        for (int i = substring.length() - 1; i >= 0; i--) {
            reversedMessage.append(substring.charAt(i));

        }
        return reversedMessage.toString();
    }
}
