package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.instagraphlite.models.entity.Picture;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserImportDTO {

    @NotNull
    @Expose
    @XmlElement
    @Size(min = 2, max = 18)
    private String username;

    @Expose
    @NotNull
    @Size(min = 4)
    private String password;

    @Expose
    @NotNull
    private String profilePicture;

    public String getUsername() {
        return username;
    }

    public UserImportDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserImportDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public UserImportDTO setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}
