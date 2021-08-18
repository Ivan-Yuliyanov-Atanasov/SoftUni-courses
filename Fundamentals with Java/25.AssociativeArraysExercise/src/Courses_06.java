import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("end")){
            String [] tokens = input.split(" : ");
            String courseName = tokens[0];
            String student = tokens[1];

            if(!courses.containsKey(courseName)){
                courses.put(courseName,new ArrayList<>());
            }
            courses.get(courseName).add(student);
            input = scan.nextLine();
        }
        courses.entrySet()
                .stream()
                .sorted((i1, i2) -> Integer.compare(i2.getValue().size(), i1.getValue().size()))
                .forEach(i-> {
                    System.out.println(i.getKey() + ": " + i.getValue().size());
                    i.getValue().stream()
                            .sorted((a1, a2)->a1.compareTo(a2))
                            .forEach(student -> System.out.println("-- " + student));
                });

    }
}
