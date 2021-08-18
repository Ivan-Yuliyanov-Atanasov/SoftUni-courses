import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> companies = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String ID = tokens[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());

                }
            if(!companies.get(companyName).contains(ID)){
                companies.get(companyName).add(ID);
            }
            input = scan.nextLine();
        }
        companies.entrySet().
                stream().
                sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue().stream()
                    .forEach(e -> System.out.println( "-- " + e ));
                });
    }
}
