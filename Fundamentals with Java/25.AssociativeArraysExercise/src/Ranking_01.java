import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> contests = new LinkedHashMap<>();
        Map<String,LinkedHashMap<String,Integer>> users = new TreeMap<>();

        String inputContest = scan.nextLine();
        while (!inputContest.equals("end of contests")){
            String [] tokens = inputContest.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contests.putIfAbsent(contest,password);
            inputContest = scan.nextLine();
        }
        String inputUser = scan.nextLine();
        while (!inputUser.equals("end of submissions")){
            String [] userTokens = inputUser.split("=>");
            String userContest = userTokens[0];
            String userPassword = userTokens[1];
            String username = userTokens[2];
            int points = Integer.parseInt(userTokens[3]);
            if(contests.containsKey(userContest)){
              if (contests.get(userContest).equals(userPassword)){
                  users.putIfAbsent(username,new LinkedHashMap<>());
                  Map<String,Integer> course = users.get(username);
                  course.putIfAbsent(userContest,points);
                  if(course.get(userContest) < points){
                      course.put(userContest,points);
                  }
              }

            }
            inputUser = scan.nextLine();
        }
        int maxPoints = 0;
        String bestCandidate = "";
        for(Map.Entry<String,LinkedHashMap<String,Integer>> user : users.entrySet()){
            int sum = user.getValue().values().stream().mapToInt(e -> e).sum();
            if (sum > maxPoints){
                maxPoints = sum;
                bestCandidate = user.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n",bestCandidate,maxPoints);
        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }
}
