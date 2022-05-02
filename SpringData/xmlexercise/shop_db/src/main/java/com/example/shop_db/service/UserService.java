package com.example.shop_db.service;

import com.example.shop_db.model.dto.UserSeedDto;
import com.example.shop_db.model.dto.UserSoldProductsRootDto;
import com.example.shop_db.model.dto.task4.UserSoldProductsDtoTask4;
import com.example.shop_db.model.dto.task4.UserSoldProductsRootDtoTask4;
import com.example.shop_db.model.entity.User;

import java.util.List;

public interface UserService {
    void seedUsers(List<UserSeedDto> users);
    User findRandomUser();
    UserSoldProductsRootDto findAllUsersWithAtLeastOneProductSold();

    UserSoldProductsRootDtoTask4 usersWithAtLeastOneSoldProductOrderedBySellsCount();
}
