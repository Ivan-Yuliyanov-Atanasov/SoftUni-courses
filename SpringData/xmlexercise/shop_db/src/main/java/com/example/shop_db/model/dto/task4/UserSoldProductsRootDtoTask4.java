package com.example.shop_db.model.dto.task4;



import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsRootDtoTask4 {
    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "user")
    private List<UserSoldProductsDtoTask4> users;

    public UserSoldProductsRootDtoTask4() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserSoldProductsDtoTask4> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductsDtoTask4> users) {
        this.users = users;
    }
}
