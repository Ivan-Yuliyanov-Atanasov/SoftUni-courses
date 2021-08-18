import java.util.*;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,List<String>> submissions = new TreeMap<>();
        Map<String,Integer> students = new TreeMap<>();
        String username;
        String inputLine = scan.nextLine();
        while (!inputLine.equals("exam finished")){
            if(inputLine.contains("banned")){
                username = (inputLine.split("-"))[0];
                students.remove(username);
            } else {
                String [] tokens = inputLine.split("-");
                username = tokens[0];
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                submissions.putIfAbsent(language,new ArrayList<>());
                submissions.get(language).add(username);
                students.putIfAbsent(username,points);
                if(students.get(username) < points){
                    students.put(username,points);
                }
            }
            inputLine = scan.nextLine();
        }
        System.out.println("Results:");
        students.entrySet().stream()
                .sorted((s1,s2)->Integer.compare(s2.getValue(),s1.getValue()))
                .forEach(s-> System.out.printf("%s | %d%n",s.getKey(),s.getValue()));
        System.out.println("Submissions:");
        submissions.entrySet().stream()
                .sorted((s1,s2)->Integer.compare(s2.getValue().size(),s1.getValue().size()))
                .forEach(s-> System.out.printf("%s - %d%n",s.getKey(),s.getValue().size()));
    }
}
