package softuni.exam.instagraphlite.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportRootDTO {

    @XmlElement(name = "post")
    private List<PostImportDTO> posts;

    public List<PostImportDTO> getPosts() {
        return posts;
    }

    public PostImportRootDTO setPosts(List<PostImportDTO> posts) {
        this.posts = posts;
        return this;
    }
}
