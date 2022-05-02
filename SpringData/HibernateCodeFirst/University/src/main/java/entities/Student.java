package entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;
    @Column(name = "attendance")
    private int attendance;
    @ManyToMany
    private Set<Course> courses;

    public Student() {
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
