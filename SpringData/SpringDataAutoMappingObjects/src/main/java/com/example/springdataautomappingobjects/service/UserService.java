package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.model.dto.UserLoginDto;
import com.example.springdataautomappingobjects.model.dto.UserRegisterDto;


public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto userLoginDto);

    String logoutUser();

    String addItem(String title);

    String buyItem();

    String removeItem(String title);

    String showGames();


}

