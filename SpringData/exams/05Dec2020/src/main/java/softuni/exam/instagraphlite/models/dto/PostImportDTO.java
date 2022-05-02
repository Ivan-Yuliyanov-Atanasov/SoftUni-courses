package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement
    @NotNull
    private UserImportDTO user;

    @XmlElement
    @NotNull
    private PictureImportDTO picture;

    public String getCaption() {
        return caption;
    }

    public PostImportDTO setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public UserImportDTO getUser() {
        return user;
    }

    public PostImportDTO setUser(UserImportDTO user) {
        this.user = user;
        return this;
    }

    public PictureImportDTO getPicture() {
        return picture;
    }

    public PostImportDTO setPicture(PictureImportDTO picture) {
        this.picture = picture;
        return this;
    }
}
