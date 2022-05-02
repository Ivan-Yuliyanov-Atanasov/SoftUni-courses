package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownRootImportDTO {

    @XmlElement(name = "town")
    List<TownImportDTO> towns;

    public TownRootImportDTO() {
    }

    public List<TownImportDTO> getTowns() {
        return towns;
    }

    public TownRootImportDTO setTowns(List<TownImportDTO> towns) {
        this.towns = towns;
        return this;
    }
}
