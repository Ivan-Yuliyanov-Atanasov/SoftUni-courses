package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeImportDTO {

    @XmlAttribute(name = "first-name")
    @NotNull
    private String firstName;

    @XmlAttribute(name = "last-name")
    @NotNull
    private String lastName;

    @XmlAttribute(name = "position")
    @NotNull
    private String position;

    @XmlElement
    @NotNull
    private String card;

    @XmlElement
    @NotNull
    private String branch;

    public String getFirstName() {
        return firstName;
    }

    public EmployeeImportDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeImportDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeImportDTO setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getCard() {
        return card;
    }

    public EmployeeImportDTO setCard(String card) {
        this.card = card;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public EmployeeImportDTO setBranch(String branch) {
        this.branch = branch;
        return this;
    }
}
