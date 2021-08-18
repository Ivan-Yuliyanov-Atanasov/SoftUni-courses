import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] names = scan.nextLine().split(", ");
        Map<String,Integer> participants = new LinkedHashMap<>();
        for (int i = 0; i < names.length; i++) {
            participants.put(names[i],0 );

        }
        String inputLine = scan.nextLine();
        while (!inputLine.equals("end of race")){

            StringBuilder name = new StringBuilder();
            int distance = 0;
            for (int i = 0; i < inputLine.length(); i++) {
                char character = inputLine.charAt(i);
                if(Character.isLetter(character)){
                    name.append(character);
                } else if (Character.isDigit(character)){
                    distance += Integer.parseInt(String.valueOf(character));
                }
            }
            if(participants.containsKey(name.toString())){
                participants.put(name.toString(),participants.get(name.toString()) + distance);
            }
            inputLine = scan.nextLine();
        }
        List<String> outputHelp = new ArrayList<>();
        outputHelp.add("1st place:");
        outputHelp.add("2nd place:");
        outputHelp.add("3rd place:");
        AtomicInteger count = new AtomicInteger(-1);
        participants.entrySet().stream()

                .sorted((p1,p2) -> Integer.compare(p2.getValue(),p1.getValue()))
                .limit(3)
                .forEach(p -> System.out.printf("%s %s%n",outputHelp.get(count.incrementAndGet()),p.getKey()));
        System.out.println();
    }
}
