package com.example.jsonexercise.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserCountDto {
    @Expose
    private Integer usersCount;
    @Expose
    private List<SellerViewDto> users;

    public UserCountDto() {
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<SellerViewDto> getUsers() {
        return users;
    }

    public void setUsers(List<SellerViewDto> users) {
        this.users = users;
    }
}
