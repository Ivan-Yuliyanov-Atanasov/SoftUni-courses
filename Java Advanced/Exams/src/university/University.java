package university;
import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (this.students.size() < this.capacity) {

            if (this.students.contains(student)) {
                return "Student is already in the university";
            } else {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());

            }
        }
        return "No seats in the university";

    }


    public String dismissStudent(Student student) {

        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) && currentStudent.getLastName().equals(student.getLastName())) {
                this.students.remove(student);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }


    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                student = currentStudent;
                break;
            }
        }
        return student;
    }


    public String getStatistics() {
        StringBuilder report = new StringBuilder();

        for (Student student : students) {

            report.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName(), student.getLastName(), student.getBestSubject()));
            report.append(System.lineSeparator());
        }

        return report.toString().trim();
    }
}


