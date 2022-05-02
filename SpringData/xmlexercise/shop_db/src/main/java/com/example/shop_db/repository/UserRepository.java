package com.example.shop_db.repository;

import com.example.shop_db.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query( "select u From User u Where size(u.soldProducts) > 0 order by u.lastName, u.firstName")
    List<User> findByProductsSoldOrderedByLastNameFirstName();

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT count (p) FROM Product p WHERE p.seller.id = u.id AND p.buyer.id IS NOT NULL) > 0")
    List<User> findUsersSoldAtLeastOneProduct();
}
