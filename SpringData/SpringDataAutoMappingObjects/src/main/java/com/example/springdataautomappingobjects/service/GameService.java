package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.model.dto.AddGameDto;
import com.example.springdataautomappingobjects.model.dto.UserDto;
import com.example.springdataautomappingobjects.model.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    String addGame(AddGameDto addGameDto);

    void setLoggedUser(UserDto userDto);

    String deleteGame(Long id);

    String editGame(List<String> data);

    List<String> viewAllGames();

    String viewSingleGameDetails(String title);

    Optional<Game> findByTitle(String title);
}
