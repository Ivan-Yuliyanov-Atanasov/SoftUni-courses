package com.example.xmlcardealer.model.dto.importData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedDto {

    @XmlAttribute
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public SupplierSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public SupplierSeedDto setImporter(boolean importer) {
        isImporter = importer;
        return this;
    }

}
