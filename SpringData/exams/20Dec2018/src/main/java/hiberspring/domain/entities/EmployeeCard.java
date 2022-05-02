package hiberspring.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_cards")
public class EmployeeCard extends BaseEntity{


    @Column(unique = true, nullable = false)
    private String number;

    public String getNumber() {
        return number;
    }

    public EmployeeCard setNumber(String number) {
        this.number = number;
        return this;
    }
}
