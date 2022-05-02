package hiberspring.domain.entities;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String position;

    @OneToOne(optional = false)
    private EmployeeCard employeeCard;

    @ManyToOne(optional = false)
    private Branch branch;

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public EmployeeCard getEmployeeCard() {
        return employeeCard;
    }

    public Employee setEmployeeCard(EmployeeCard employeeCard) {
        this.employeeCard = employeeCard;
        return this;
    }

    public Branch getBranch() {
        return branch;
    }

    public Employee setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }
}
