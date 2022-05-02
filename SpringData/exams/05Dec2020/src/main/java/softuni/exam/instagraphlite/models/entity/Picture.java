package softuni.exam.instagraphlite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{


    @Column(nullable = false, unique = true)
    private String path;

    @Column(nullable = false)
    private Double size;

    public String getPath() {
        return path;
    }

    public Picture setPath(String path) {
        this.path = path;
        return this;
    }

    public Double getSize() {
        return size;
    }

    public Picture setSize(Double size) {
        this.size = size;
        return this;
    }
}
