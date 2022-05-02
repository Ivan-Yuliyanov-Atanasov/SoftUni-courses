package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedDto {

    @Expose
    @XmlElement
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Expose
    @XmlElement(name = "picture")
    @NotNull
    private PictureSeedDto picture;

    public TeamSeedDto() {
    }

    public String getName() {
        return name;
    }

    public TeamSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public PictureSeedDto getPicture() {
        return picture;
    }

    public TeamSeedDto setPicture(PictureSeedDto picture) {
        this.picture = picture;
        return this;
    }
}
