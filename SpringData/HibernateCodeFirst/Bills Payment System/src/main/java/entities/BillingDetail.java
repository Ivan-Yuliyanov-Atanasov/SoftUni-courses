package entities;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "billing_details")
public abstract class BillingDetail extends BaseEntity{


    @Column(name = "number", nullable = false, unique = true, length = 30)
    private String number;

    @ManyToOne
    private User owner;


    public BillingDetail() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
