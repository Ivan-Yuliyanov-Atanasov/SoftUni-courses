package com.example.shop_db.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsRootDto {
    @XmlElement(name = "user")
    private List<UserSoldProductsDto> users;

    public UserSoldProductsRootDto() {
    }

    public List<UserSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductsDto> users) {
        this.users = users;
    }
}
