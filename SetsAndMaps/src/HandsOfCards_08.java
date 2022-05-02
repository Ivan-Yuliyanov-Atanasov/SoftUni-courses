import java.util.*;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = "";
        while(!(input = scan.nextLine()).equals("JOKER")){
            String [] tokens = input.split(": ");
            String name = tokens[0];
            String [] cards = tokens [1].split(", ");
            if(!players.containsKey(name)){
                Set<String> deck = new LinkedHashSet<>();
                players.put(name,deck);
            }
            for (int i = 0; i < cards.length; i++) {
                String currentCard = cards[i];

                    players.get(name).add(currentCard);

            }
        }
        for (Map.Entry<String,Set<String>> entry : players.entrySet()) {
            int sum = 0;
            Set<String> currentSet = entry.getValue();
            for (String s : currentSet) {
                String power = "";
                String multiplier = "";
                if(s.length() == 3){
                     power = s.substring(0,2);
                     multiplier = s.substring(2);
                } else {
                     power = s.substring(0,1);
                     multiplier = s.substring(1);
                }

                int powerNumber = 0;
                int multiplierNumber = 0;

                switch (multiplier){
                    case "S":
                        multiplierNumber = 4;
                        break;
                    case "H":
                        multiplierNumber = 3;
                        break;
                    case "D":
                        multiplierNumber = 2;
                        break;
                    case "C":
                        multiplierNumber = 1;
                        break;
                }
                try {
                    powerNumber = Integer.parseInt(power);
                } catch (Exception e){
                    switch (power){
                        case "J":
                            powerNumber = 11;
                            break;
                        case "Q":
                            powerNumber = 12;
                            break;
                        case "K":
                            powerNumber = 13;
                            break;
                        case "A":
                            powerNumber = 14;
                            break;
                    }
                }
                sum += powerNumber * multiplierNumber;

            }
            System.out.printf("%s: %d%n",entry.getKey(),sum);

        }
    }
}
