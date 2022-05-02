package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartViewRootDto {

    @XmlElement(name = "part")
    private List<PartViewDto> parts;

    public PartViewRootDto() {

    }

    public List<PartViewDto> getParts() {
        return parts;
    }

    public PartViewRootDto setParts(List<PartViewDto> parts) {
        this.parts = parts;
        return this;
    }
}
