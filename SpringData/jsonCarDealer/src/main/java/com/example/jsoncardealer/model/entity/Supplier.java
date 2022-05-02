package com.example.jsoncardealer.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{


    @Column
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Supplier() {
    }


    public String getName() {
        return name;
    }

    public Supplier setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public Supplier setImporter(boolean importer) {
        isImporter = importer;
        return this;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public Supplier setParts(Set<Part> parts) {
        this.parts = parts;
        return this;
    }
}
