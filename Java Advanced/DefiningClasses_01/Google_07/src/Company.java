public class Company {
    String name;
    String department;
    double salary;

    @Override
    public String toString() {
        return String.format("%s %s %.02f",this.name,this.department,this.salary);
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
