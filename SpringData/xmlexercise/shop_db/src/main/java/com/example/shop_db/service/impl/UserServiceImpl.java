package com.example.shop_db.service.impl;

import com.example.shop_db.model.dto.*;
import com.example.shop_db.model.dto.task4.ProductViewDtoTask4;
import com.example.shop_db.model.dto.task4.SoldProductDtoTask4;
import com.example.shop_db.model.dto.task4.UserSoldProductsDtoTask4;
import com.example.shop_db.model.dto.task4.UserSoldProductsRootDtoTask4;
import com.example.shop_db.model.entity.Category;
import com.example.shop_db.model.entity.Product;
import com.example.shop_db.model.entity.User;
import com.example.shop_db.repository.UserRepository;
import com.example.shop_db.service.UserService;
import com.example.shop_db.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {

        if (userRepository.count() > 0) {
            return;
        }
        users.stream().filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);

    }

    @Override
    public UserSoldProductsRootDto findAllUsersWithAtLeastOneProductSold() {
        UserSoldProductsRootDto userDto = new UserSoldProductsRootDto();
        userDto.setUsers(userRepository.findByProductsSoldOrderedByLastNameFirstName().stream()
                .map(user -> {

                    Set<Product> products = user.getSoldProducts();
                    products.removeIf(product -> product.getBuyer() == null);
                    SoldProductDto soldProductDto = new SoldProductDto();
                    soldProductDto.setSoldProducts(products.stream().map(product -> modelMapper.
                            map(product, ProductViewDto.class)).collect(Collectors.toList()));

                    UserSoldProductsDto userSoldProductsDto = modelMapper.map(user, UserSoldProductsDto.class);
                    userSoldProductsDto.setSoldProductDto(soldProductDto);

                    return userSoldProductsDto;
                }).filter(userSoldProductsDto -> !userSoldProductsDto.getSoldProductDto().getSoldProducts().isEmpty())
                .collect(Collectors.toList()));


        return userDto;
    }

    @Override
    public UserSoldProductsRootDtoTask4 usersWithAtLeastOneSoldProductOrderedBySellsCount() {
        List<User> sellers = userRepository.findUsersSoldAtLeastOneProduct().stream()

                .map(user -> {
                    Set<Product> products = user.getSoldProducts();
                    products.removeIf(product -> product.getBuyer() == null);
                    user.setSoldProducts(products);
                    return user;
                })
                .sorted((u1, u2) -> {

                    int result = Integer.compare(u2.getSoldProducts().size(), u1.getSoldProducts().size());
                    if (result == 0) {
                        result = u1.getLastName().compareTo(u2.getLastName());
                    }

                    return result;
                })
                .collect(Collectors.toList());

        UserSoldProductsRootDtoTask4 userRootDto = new UserSoldProductsRootDtoTask4();
        userRootDto.setCount(sellers.size());
        userRootDto.setUsers(sellers.stream()
                .map(user -> {
                    SoldProductDtoTask4 soldProductDtoTask4 = new SoldProductDtoTask4();
                    soldProductDtoTask4.setSoldProducts(user.getSoldProducts().stream().map(product -> modelMapper.
                            map(product, ProductViewDtoTask4.class)).collect(Collectors.toList()));
                    soldProductDtoTask4.setCount(user.getSoldProducts().size());
                    UserSoldProductsDtoTask4 userSoldProductsDtoTask4 = modelMapper.map(user, UserSoldProductsDtoTask4.class);
                    userSoldProductsDtoTask4.setSoldProductDto(soldProductDtoTask4);
                    return userSoldProductsDtoTask4;
                }).collect(Collectors.toList()));

        return userRootDto;
    }
}
