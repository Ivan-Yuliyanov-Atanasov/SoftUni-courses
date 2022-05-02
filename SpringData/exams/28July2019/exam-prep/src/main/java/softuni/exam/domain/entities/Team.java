package softuni.exam.domain.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Picture picture;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public Team setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
