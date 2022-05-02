package com.example.jsonexercise.service;

import com.example.jsonexercise.model.dto.SellerDto;
import com.example.jsonexercise.model.dto.UserCountDto;
import com.example.jsonexercise.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();

    List<SellerDto> findAllUsersWithAtLeastOneProductSold();

    UserCountDto usersWithAtLeastOneSoldProductOrderedBySellsCount();
}
