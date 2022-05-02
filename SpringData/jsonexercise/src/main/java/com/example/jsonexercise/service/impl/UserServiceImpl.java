package com.example.jsonexercise.service.impl;

import com.example.jsonexercise.model.dto.*;
import com.example.jsonexercise.model.entity.Product;
import com.example.jsonexercise.model.entity.User;
import com.example.jsonexercise.repository.UserRepository;
import com.example.jsonexercise.service.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(Gson gson, ModelMapper modelMapper, UserRepository userRepository, ValidationUtil validationUtil) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {

        if (userRepository.count() > 0) {
            return;
        }

        Arrays.stream(gson.fromJson(Files.readString(Path.of(USERS_FILE_PATH)), UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(UserSeedDto -> modelMapper.map(UserSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);

    }

    @Override
    public List<SellerDto> findAllUsersWithAtLeastOneProductSold() {
        return userRepository.findByProductsSoldOrderedByLastNameFirstName().stream()
                .map(user -> {

                    Set<Product> products = user.getSoldProducts();
                    products.removeIf(product -> product.getBuyer() == null);

                    return modelMapper.map(user, SellerDto.class);
                }).filter(sellerDto -> !sellerDto.getSoldProducts().isEmpty())
                .collect(Collectors.toList());
    }

    public UserCountDto usersWithAtLeastOneSoldProductOrderedBySellsCount() {
        List<User> sellers = userRepository.findUsersSoldAtLeastOneProduct().stream()

                .map(user -> {
                    Set<Product> products = user.getSoldProducts();
                    products.removeIf(product -> product.getBuyer() == null);
                    user.setSoldProducts(products);
                    return user;
                })
                .sorted((u1, u2) -> {

                    int result = Integer.compare(u2.getSoldProducts().size(), u1.getSoldProducts().size());
                    if (result == 0){
                        result = u1.getLastName().compareTo(u2.getLastName());
                    }

                    return result;
                })
                .collect(Collectors.toList());

        List<SellerViewDto> sellerViewDtos = sellers.stream().map(seller -> {
            List<ProductNamePriceDto> collect = seller.getSoldProducts().stream().
                    map(product -> modelMapper.map(product, ProductNamePriceDto.class)).collect(Collectors.toList());
            ProductsCountDto productsCountDto = new ProductsCountDto();
            productsCountDto.setCount(collect.size());
            productsCountDto.setProducts(collect);
            SellerViewDto sellerViewDto = modelMapper.map(seller, SellerViewDto.class);
            sellerViewDto.setSoldProducts(productsCountDto);
            return sellerViewDto;


        }).collect(Collectors.toList());
        UserCountDto userCountDto = new UserCountDto();
        userCountDto.setUsersCount(sellers.size());
        userCountDto.setUsers(sellerViewDtos);
        return userCountDto;


    }
}
