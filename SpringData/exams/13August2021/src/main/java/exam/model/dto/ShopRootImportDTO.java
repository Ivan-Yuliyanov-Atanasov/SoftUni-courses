package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopRootImportDTO {

    @XmlElement(name = "shop")
    List<ShopImportDTO> shops;

    public ShopRootImportDTO() {
    }

    public List<ShopImportDTO> getShops() {
        return shops;
    }

    public ShopRootImportDTO setShops(List<ShopImportDTO> shops) {
        this.shops = shops;
        return this;
    }
}
