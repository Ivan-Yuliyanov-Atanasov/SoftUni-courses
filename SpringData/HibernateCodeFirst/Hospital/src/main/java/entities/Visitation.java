package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity{

    @Basic
    private Date date;
    @Column(columnDefinition = "TEXT")
    private String comments;
    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;

    public Visitation() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
