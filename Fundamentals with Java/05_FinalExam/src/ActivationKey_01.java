import java.util.Scanner;

public class ActivationKey_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();
        while(!inputLine.equals("Generate")) {
            String[] tokens = inputLine.split(">>>");
            String command = tokens[0];
            switch (command){
                case "Contains":
                    String substring = tokens[1];
                    if(message.toString().contains(substring)){
                        System.out.printf("%s contains %s%n",message.toString(),substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    message.delete(startIndex,endIndex);
                    System.out.println(message.toString());
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int firstIndex = Integer.parseInt(tokens[2]);
                    int secondIndex = Integer.parseInt(tokens[3]);
                    String firstPart = message.substring(0,firstIndex);
                    String partToChange = message.substring(firstIndex,secondIndex);
                    String lastPart = message.substring(secondIndex);

                    if(upperOrLower.equals("Upper")){
                        partToChange = partToChange.toUpperCase();
                    } else {
                        partToChange = partToChange.toLowerCase();
                    }
                    message.setLength(0);
                    message.append(firstPart);
                    message.append(partToChange);
                    message.append(lastPart);
                    System.out.println(message.toString());
                    break;
            }
            inputLine = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s",message.toString());

    }
}
