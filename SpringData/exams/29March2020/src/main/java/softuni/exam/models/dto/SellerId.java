package softuni.exam.models.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerId {

    @XmlElement
    private Long id;

    public SellerId() {
    }

    public Long getId() {
        return id;
    }

    public SellerId setId(Long id) {
        this.id = id;
        return this;
    }
}
