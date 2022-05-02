package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if(this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        return this.employees.removeIf(e -> e.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        List<Employee> sortedByAge = this.employees.stream().sorted((e1,e2) -> Integer.compare(e2.getAge(),e1.getAge())).collect(Collectors.toList());
        return sortedByAge.get(0);
    }
    public Employee getEmployee(String name){
        Employee employee = null;
        for (Employee currentEmployee : this.employees) {
            if(currentEmployee.getName().equals(name)){
                employee = currentEmployee;
            }
        }
        return employee;
    }

    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("Employees working at Cafe %s:",this.name));
        report.append(System.lineSeparator());
        for (Employee employee : employees) {

                report.append(employee);
                report.append(System.lineSeparator());
            }

        return report.toString();
    }
}
