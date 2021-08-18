import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Done")){
            String [] tokens = inputLine.split(" ");
            String command = tokens[0];
            boolean print = true;
            switch (command){
                case "TakeOdd":
                    StringBuilder oddCharMessage = new StringBuilder();
                    for (int i = 1; i < message.length() ; i++) {
                        if(i % 2 == 1){
                            oddCharMessage.append(message.charAt(i));
                        }

                    }
                    message.setLength(0);
                    message.append(oddCharMessage);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    message.delete(index, index + length);
                    break;
                case "Substitute":

                    String stringToReplace = tokens[1];
                    String replacementString = tokens[2];
                    if (message.toString().contains(stringToReplace)) {
                        String newMessage = message.toString().replace(stringToReplace,replacementString);
                        message.setLength(0);
                        message.append(newMessage);
                    } else {
                        print = false;
                        System.out.println("Nothing to replace!");
                    }


                    break;
            }
             if (print){
                 System.out.println(message.toString());
             }

            inputLine = scan.nextLine();
        }
        System.out.printf("Your password is: %s",message.toString());
    }
}
