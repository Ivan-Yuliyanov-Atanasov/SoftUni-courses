import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> users = new TreeMap<>();
        Map<String, LinkedHashMap<String, Integer>> contests = new LinkedHashMap<>();
        String inputLine = scan.nextLine();
        while (!inputLine.equals("no more time")){
            String [] tokens = inputLine.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);
            LinkedHashMap<String,Integer> user = new LinkedHashMap<>();
            user.put(username,points);
            if(!contests.containsKey(contest)){
                contests.put(contest,user);
                if(!users.containsKey(username)){
                    users.put(username,points);
                } else {
                    users.put(username,users.get(username) + points);
                }
            } else {
                if(!contests.get(contest).containsKey(username)){
                    contests.get(contest).put(username,points);
                    if(!users.containsKey(username)){
                        users.put(username,points);
                    } else {
                        users.put(username,users.get(username) + points);
                    }
                } else {
                    if(contests.get(contest).get(username) < points){
                        int diff = points - contests.get(contest).get(username);
                        contests.get(contest).put(username,points);
                        users.put(username,users.get(username) + diff);
                    }
                }

            }

            inputLine = scan.nextLine();
        }


        contests.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key,value.size());
            AtomicInteger counter = new AtomicInteger(0);

            value.entrySet().stream().
                    sorted((f, s) -> {
                        int firstNumber = f.getValue();
                        int secondNumber = s.getValue();
                        if(firstNumber == secondNumber){
                            return f.getKey().compareTo(s.getKey());
                        }
                        return Integer.compare(secondNumber,firstNumber);

                        }).
                    forEach(i -> System.out.printf("%d. %s <::> %d%n",counter.incrementAndGet(),i.getKey(), i.getValue()));
        });
        System.out.println("Individual standings:");
        AtomicInteger counter = new AtomicInteger(0);
        users.entrySet().stream()
                .sorted((v1,v2)->Integer.compare(v2.getValue(),v1.getValue()))
                .forEach(i-> {
                    System.out.printf("%d. %s -> %d%n",counter.incrementAndGet(),i.getKey(), i.getValue());

                });

    }
}
