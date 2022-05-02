package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureImportDTO {

    @NotNull
    @Expose
    @XmlElement
    private String path;

    @Expose
    @NotNull
    @Min(500)
    @Max(60000)
    private Double size;

    public String getPath() {
        return path;
    }

    public PictureImportDTO setPath(String path) {
        this.path = path;
        return this;
    }

    public Double getSize() {
        return size;
    }

    public PictureImportDTO setSize(Double size) {
        this.size = size;
        return this;
    }
}
