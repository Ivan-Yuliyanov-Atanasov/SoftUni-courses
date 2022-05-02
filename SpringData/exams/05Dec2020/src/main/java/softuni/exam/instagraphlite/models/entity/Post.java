package softuni.exam.instagraphlite.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{


    @Column(nullable = false)
    private String caption;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Picture picture;

    public String getCaption() {
        return caption;
    }

    public Post setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public Post setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
