package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerImportRootDTO {

    @XmlElement(name = "seller")
    private List<SellerImportDTO> sellers;

    public SellerImportRootDTO() {
    }

    public List<SellerImportDTO> getSellers() {
        return sellers;
    }

    public SellerImportRootDTO setSellers(List<SellerImportDTO> sellers) {
        this.sellers = sellers;
        return this;
    }
}
