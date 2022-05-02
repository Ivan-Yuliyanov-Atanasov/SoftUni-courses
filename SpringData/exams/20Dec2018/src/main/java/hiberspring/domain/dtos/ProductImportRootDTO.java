package hiberspring.domain.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportRootDTO {


    @XmlElement(name = "product")
    private List<ProductImportDTO> products;

    public ProductImportRootDTO() {
    }

    public List<ProductImportDTO> getProducts() {
        return products;
    }

    public ProductImportRootDTO setProducts(List<ProductImportDTO> products) {
        this.products = products;
        return this;
    }
}
