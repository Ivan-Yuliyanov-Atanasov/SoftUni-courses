import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }
        students.entrySet()
                .stream()
                .filter(i-> i.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((s1, s2) -> {
                    double result1 = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double result2 = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(result2, result1);
                })
                .forEach(student -> System.out.printf("%s -> %.2f%n",student.getKey(),
                        student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
    }
}
