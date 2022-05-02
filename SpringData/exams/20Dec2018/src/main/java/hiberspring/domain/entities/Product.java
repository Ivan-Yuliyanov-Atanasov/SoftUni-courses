package hiberspring.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer clients;

    @ManyToOne(optional = false)
    private Branch branch;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getClients() {
        return clients;
    }

    public Product setClients(Integer clients) {
        this.clients = clients;
        return this;
    }

    public Branch getBranch() {
        return branch;
    }

    public Product setBranch(Branch branch) {
        this.branch = branch;
        return this;
    }
}
