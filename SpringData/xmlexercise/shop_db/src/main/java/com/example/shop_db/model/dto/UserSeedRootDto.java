package com.example.shop_db.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {
    @XmlElement(name = "user")
    List<UserSeedDto> users;

    public UserSeedRootDto() {
    }


    public List<UserSeedDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDto> users) {
        this.users = users;
    }
}
