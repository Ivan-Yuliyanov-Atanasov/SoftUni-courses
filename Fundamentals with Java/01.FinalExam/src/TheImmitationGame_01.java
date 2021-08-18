import java.util.Scanner;

public class TheImmitationGame_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Decode")){
            String [] tokens = inputLine.split("\\|");
            String command = tokens[0];
            switch (command){
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String lettersToMove = encryptedMessage.substring(0,Math.min(numberOfLetters,encryptedMessage.length()));
                    encryptedMessage.delete(0,Math.min(numberOfLetters,encryptedMessage.length()));
                    encryptedMessage.append(lettersToMove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String stringToAdd = tokens[2];
//                    if (index >= 0 && index <= encryptedMessage.length()){
                        encryptedMessage.insert(index,stringToAdd);
//                    }

                    break;
                case "ChangeAll":
                    String stringToReplace = tokens[1];
                    String replacement = tokens[2];
                    String changed = "";
                    if(encryptedMessage.toString().contains(stringToReplace)){
                        changed = encryptedMessage.toString().replace(stringToReplace,replacement);

                    }
                    encryptedMessage.setLength(0);
                    encryptedMessage.append(changed);
                    changed = "";

                    break;
            }
            inputLine = scan.nextLine();
        }

        System.out.printf("The decrypted message is: %s",encryptedMessage.toString());

    }
}
