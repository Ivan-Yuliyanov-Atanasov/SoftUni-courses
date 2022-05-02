package com.example.springdataautomappingobjects;

import com.example.springdataautomappingobjects.model.dto.AddGameDto;
import com.example.springdataautomappingobjects.model.dto.UserLoginDto;
import com.example.springdataautomappingobjects.model.dto.UserRegisterDto;
import com.example.springdataautomappingobjects.service.GameService;
import com.example.springdataautomappingobjects.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while(true){
            System.out.println("Please enter command:");
            String [] tokens = bufferedReader.readLine().split("\\|");
            String command = tokens [0];

            switch (command){
                case "RegisterUser":
                    UserRegisterDto userRegisterDto = new UserRegisterDto(tokens[1],tokens[2],tokens[3],tokens[4]);
                    System.out.println(userService.registerUser(userRegisterDto));
                    break;

                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(tokens[1],tokens[2]);
                    System.out.println(userService.loginUser(userLoginDto));
                    break;

                case "Logout":
                    System.out.println(userService.logoutUser());
                    break;

                case "AddGame":
                    LocalDate date = LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    AddGameDto addGameDto = new AddGameDto(tokens[1], new BigDecimal(tokens[2]), Double.parseDouble(tokens[3]),tokens[4],tokens[5],tokens[6],date);
                    System.out.println(gameService.addGame(addGameDto));
                    break;

                case "EditGame":
                    List<String> data = Arrays.stream(tokens).skip(1).collect(Collectors.toList());
                    System.out.println(gameService.editGame(data));
                    break;

                case "DeleteGame":
                    System.out.println(gameService.deleteGame(Long.parseLong(tokens[1])));
                    break;

                case "AllGames":
                    gameService.viewAllGames().forEach(System.out::println);
                    break;
                    // на едното място пише DetailsGame(има s)
                case "DetailGame":
                    System.out.println(gameService.viewSingleGameDetails(tokens[1]));
                    break;

                case "OwnedGames":
                    System.out.println(userService.showGames());
                    break;

                case "AddItem":
                    System.out.println(userService.addItem(tokens[1]));
                    break;

                case "RemoveItem":
                    System.out.println(userService.removeItem(tokens[1]));
                    break;

                case "BuyItem":
                    System.out.println(userService.buyItem());
                    break;

            }
        }

    }
}
