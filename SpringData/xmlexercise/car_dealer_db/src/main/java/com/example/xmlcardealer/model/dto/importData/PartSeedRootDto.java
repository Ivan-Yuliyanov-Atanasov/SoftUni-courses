package com.example.xmlcardealer.model.dto.importData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedRootDto {
    @XmlElement(name = "part")
    private List<PartSeedDto> parts;

    public PartSeedRootDto() {
    }

    public List<PartSeedDto> getParts() {
        return parts;
    }

    public PartSeedRootDto setParts(List<PartSeedDto> parts) {
        this.parts = parts;
        return this;
    }
}
