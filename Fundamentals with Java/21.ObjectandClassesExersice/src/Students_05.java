import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            Student student = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            students.add(student);

        }

        students.stream()
                .sorted((a1, a2) -> Double.compare(a2.getGrade(), a1.getGrade()))
        .forEach(student -> System.out.printf("%s %s: %.2f%n",student.getFirstName(),student.getLastName(),student.getGrade()));
    }
    static class Student{
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }
        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public double getGrade(){
            return grade;
        }
    }
}
