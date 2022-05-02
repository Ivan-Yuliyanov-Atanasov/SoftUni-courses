import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Employee>> companies = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = new Employee(name, salary, position, department);
            if(tokens.length == 6){
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            } else if (tokens.length == 5){
                if(tokens[4].contains("@")){
                    employee.setEmail(tokens[4]);
                } else {
                    employee.setAge(Integer.parseInt(tokens[4]));
                }
            }
            if(!companies.containsKey(department)){
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                companies.put(department,employees);
            } else {
                companies.get(department).add(employee);
            }
        }
        companies.entrySet().stream()
                .sorted((c1,c2) -> {
                    double averageSalaryFirstDepartment = c2.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0);
                    double averageSalarySecondDepartment = c1.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0);
                    return Double.compare(averageSalaryFirstDepartment,averageSalarySecondDepartment);
                })
                .limit(1)
                .forEach(d -> {
                    System.out.printf("Highest Average Salary: %s%n",d.getKey());
                    d.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                            .forEach(e -> System.out.printf("%s %.02f %s %d%n",e.getName(),e.getSalary(),e.getEmail(),e.getAge()));
                });
    }
}
