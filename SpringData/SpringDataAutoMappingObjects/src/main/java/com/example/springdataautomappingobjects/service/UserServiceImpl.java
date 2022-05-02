package com.example.springdataautomappingobjects.service;

import com.example.springdataautomappingobjects.model.Role;
import com.example.springdataautomappingobjects.model.dto.GameDto;
import com.example.springdataautomappingobjects.model.dto.UserDto;
import com.example.springdataautomappingobjects.model.dto.UserLoginDto;
import com.example.springdataautomappingobjects.model.dto.UserRegisterDto;
import com.example.springdataautomappingobjects.model.entity.Game;
import com.example.springdataautomappingobjects.model.entity.User;
import com.example.springdataautomappingobjects.repository.UserRepository;
import com.example.springdataautomappingobjects.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final GameService gameService;
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private UserDto loggedUser;


    public UserServiceImpl(GameService gameService, UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gameService = gameService;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;

        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {

        StringBuilder output = new StringBuilder();

        if (validationUtil.isValid(userRegisterDto)) {
            if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
                output.append("Wrong confirm password");
            } else {
                User user = modelMapper.map(userRegisterDto, User.class);
                if (userRepository.count() == 0) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                userRepository.save(user);
                output.append(String.format("%s was registered%n", user.getFullName()));

            }
        } else {
            validationUtil.violation(userRegisterDto).forEach(e -> output.append(String.format("%s%n", e.getMessage())));

        }

        return output.toString().trim();

    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        StringBuilder output = new StringBuilder();

        Optional<User> user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (user.isPresent()) {
            if (this.loggedUser != null) {
                output.append("Cannot log in. There is already logged in user.");
            } else {
                this.loggedUser = modelMapper.map(user.get(), UserDto.class);
                gameService.setLoggedUser(this.loggedUser);
                output.append(String.format("Successfully logged in %s", loggedUser.getFullName()));
            }

        } else {
            output.append("Incorrect email / password");
        }

        return output.toString();
    }

    @Override
    public String logoutUser() {
        if (this.loggedUser == null) {
            return "Cannot log out. No user was logged in.";
        } else {
            String output = String.format("User %s successfully logged out", loggedUser.getFullName());
            User user = userRepository.findByEmail(loggedUser.getEmail()).orElse(null);
            user.getShoppingCart().clear();
            userRepository.save(user);
            this.loggedUser = null;
            return output;
        }

    }

    @Override
    public String addItem(String title) {
        StringBuilder output = new StringBuilder();
        if(this.loggedUser == null){
            return "Cannot add items to the cart. No user is logged in.";
        }
        Optional<Game> game = gameService.findByTitle(title);
        if (game.isPresent()){
            User user = userRepository.findByEmail(loggedUser.getEmail()).orElse(null);
            Game gameInShoppingCart = user.getShoppingCart().stream().filter(g -> g.getTitle().equals(title)).findFirst().orElse(null);
            Game gameInUserGames = user.getGames().stream().filter(g -> g.getTitle().equals(title)).findFirst().orElse(null);
            if (gameInShoppingCart == null && gameInUserGames == null){
                user.getShoppingCart().add(game.get());
                output.append(String.format("%s added to cart.",title));
                userRepository.save(user);
            } else {
                output.append(String.format("%s already had %s.",user.getFullName(),title));
            }

        } else {
            output.append(String.format("There is no game %s in the game store.", title));
        }

        return output.toString();
    }

    @Override
    public String buyItem() {
        StringBuilder output = new StringBuilder();
        if(this.loggedUser == null){
            return "Cannot add items to the cart. No user is logged in.";
        }
        User user = userRepository.findByEmail(loggedUser.getEmail()).orElse(null);
        if (user.getShoppingCart().isEmpty()){
            return "There are no items in the shopping cart.";
        } else {
            output.append("Successfully bought games:").append(System.lineSeparator());
            for (Game game : user.getShoppingCart()) {
                user.getGames().add(game);
                output.append(String.format("\t-%s",game.getTitle())).append(System.lineSeparator());

            }
            user.getShoppingCart().clear();
            userRepository.save(user);
        }
        return output.toString().trim();
    }

    @Override
    public String removeItem(String title) {
        StringBuilder output = new StringBuilder();
        if(this.loggedUser == null){
            return "Cannot remove items from the cart. No user is logged in.";
        }
        User user = userRepository.findByEmail(loggedUser.getEmail()).orElse(null);
        if (user.getShoppingCart().isEmpty()){
            return "There are no items in the shopping cart.";
        } else {
            Game game = user.getShoppingCart().stream().filter(g -> g.getTitle().equals(title)).findFirst().orElse(null);
            if (game == null){
                output.append(String.format("There is no game %s in the shopping cart.", title));
            } else {
                user.getShoppingCart().remove(game);
                output.append(String.format("%s removed from cart.",title));
                userRepository.save(user);
            }
        }
        return output.toString();
    }

    @Override
    public String showGames() {
        StringBuilder output = new StringBuilder();
        if(this.loggedUser == null){
            return "Cannot show games. No user is logged in.";
        }
        User user = userRepository.findByEmail(loggedUser.getEmail()).orElse(null);
        if (user.getGames().isEmpty()){
            return String.format("%s doesn't own any games.",user.getFullName());
        } else {
            for (Game game : user.getGames()) {
                GameDto gameDto = modelMapper.map(game, GameDto.class);
                output.append(gameDto.getTitle()).append(System.lineSeparator());

            }
        }
        return output.toString().trim();
    }


}
