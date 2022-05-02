package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.model.Role;
import com.example.springdataautomappingobjects.model.dto.AddGameDto;
import com.example.springdataautomappingobjects.model.dto.UserDto;
import com.example.springdataautomappingobjects.model.dto.ViewAllGameDto;
import com.example.springdataautomappingobjects.model.dto.ViewSingleGameDto;
import com.example.springdataautomappingobjects.model.entity.Game;
import com.example.springdataautomappingobjects.model.entity.User;
import com.example.springdataautomappingobjects.repository.GameRepository;
import com.example.springdataautomappingobjects.repository.UserRepository;
import com.example.springdataautomappingobjects.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final ValidationUtil validationUtil;
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;
    private final UserRepository userRepository;


    public GameServiceImpl(ValidationUtil validationUtil, GameRepository gameRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.validationUtil = validationUtil;
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;

        this.userRepository = userRepository;
    }

    @Override
    public String addGame(AddGameDto addGameDto) {
        StringBuilder output = new StringBuilder();

        if (userDto == null) {
            output.append("There is no logged in user.").append(System.lineSeparator());
        } else if (!userDto.getRole().equals(Role.ADMIN)) {
            output.append("The logged user is not an admin.").append(System.lineSeparator());
        } else if (validationUtil.isValid(addGameDto)) {
            Game game = modelMapper.map(addGameDto, Game.class);
            output.append(String.format("Added %s%n", game.getTitle()));
            gameRepository.save(game);

        } else {
            Set<ConstraintViolation<AddGameDto>> violations = validationUtil.violation(addGameDto);
            violations.forEach(e -> output.append(e.getMessage()).append(System.lineSeparator()));
        }
        return output.toString().trim();
    }

    @Override
    public void setLoggedUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String deleteGame(Long id) {
        StringBuilder output = new StringBuilder();
        Optional<Game> game = gameRepository.findById(id);

        if (game.isPresent()) {
            if (userDto == null) {
                output.append("There is no logged in user.");
            } else if (!userDto.getRole().equals(Role.ADMIN)) {
                output.append("The logged user is not an admin.");
            } else {
                List<User> users = userRepository.findAll();
                for (User user : users) {
                    for (Game userGame : user.getGames()) {
                        if (userGame.getTitle().equals(game.get().getTitle())){
                            user.getGames().remove(userGame);
                            break;
                        }
                    }
                    userRepository.save(user);

                }
                User user = userRepository.findByEmail(userDto.getEmail()).orElse(null);
                Game currentGame = user.getShoppingCart().stream().filter(g -> g.getTitle().equals(game.get().getTitle())).findFirst().orElse(null);
                if (currentGame != null) {
                    user.getShoppingCart().remove(currentGame);
                    userRepository.saveAndFlush(user);
                }

                gameRepository.delete(game.get());
                output.append(String.format("Deleted %s", game.get().getTitle()));
            }
        } else {
            output.append(String.format("There is no game with %d in the game store.", id));
        }
        return output.toString();
    }

    @Override
    public String editGame(List<String> data) {
        StringBuilder output = new StringBuilder();
        Optional<Game> game = gameRepository.findById(Long.parseLong(data.get(0)));

        if (game.isPresent()) {
            if (userDto == null) {
                output.append("There is no logged in user.");
            } else if (!userDto.getRole().equals(Role.ADMIN)) {
                output.append("The logged user is not an admin.");
            } else {
                Game currentGame = game.get();
                changeGame(currentGame,data);
                gameRepository.save(currentGame);
                output.append(String.format("Edited %s", game.get().getTitle()));
            }
        } else {
            output.append(String.format("There is no game with id=%d in the game store.", Long.parseLong(data.get(0))));
        }
        return output.toString();
    }

    @Override
    public List<String> viewAllGames() {
        List<Game> allGames = gameRepository.findAll();
        List<String> output = new ArrayList<>();
        if (!allGames.isEmpty()){
            for (Game game : allGames) {
                ViewAllGameDto viewAllGameDto = modelMapper.map(game,ViewAllGameDto.class);
                output.add(String.format("%s %.2f",viewAllGameDto.getTitle(),viewAllGameDto.getPrice()));
            }

        } else {
            output.add("Game store is empty.");

        }
        return output;
    }

    @Override
    public String viewSingleGameDetails(String title) {
        StringBuilder output = new StringBuilder();
        Optional<Game> game = gameRepository.findByTitle(title);

        if (game.isPresent()){
            ViewSingleGameDto viewSingleGameDto = modelMapper.map(game.get(),ViewSingleGameDto.class);
            output.append(String.format("Title: %s\n" +
                    "Price: %.2f\n" +
                    "Description: %s\n" +
                    "Release date: %s",viewSingleGameDto.getTitle(),viewSingleGameDto.getPrice(),viewSingleGameDto.getDescription(),viewSingleGameDto.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        } else {
            output.append(String.format("There is no game %s in the game store.", title));
        }

        return output.toString();
    }

    @Override
    public Optional<Game> findByTitle(String title) {
        return gameRepository.findByTitle(title);
    }

    private void changeGame(Game game, List<String> data) {
        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("=");
            String property = tokens[0];

            switch (property) {
                case "size":
                    game.setSize(Double.parseDouble(tokens[1]));
                    break;
                case "price":
                    game.setPrice(new BigDecimal(tokens[1]));
                    break;
                case "description":
                    game.setDescription(tokens[1]);
                    break;
                case "trailer":
                    game.setTrailer(tokens[1]);
                    break;
                case "image thumbnail":
                    game.setImageThumbnail(tokens[1]);
                    break;


            }


        }
    }
}

