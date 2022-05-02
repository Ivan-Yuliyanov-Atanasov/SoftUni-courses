package hiberspring.domain.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Town town;


    @OneToMany(mappedBy = "branch")
    private Set<Product> products;

    public String getName() {
        return name;
    }

    public Branch setName(String name) {
        this.name = name;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Branch setTown(Town town) {
        this.town = town;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
