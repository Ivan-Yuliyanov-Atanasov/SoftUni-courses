package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByEmail(String email);


    @Query("SELECT p From Player p join p.stat s where p.birthDate BETWEEN ?1 AND ?2 order by s.shooting desc, s.passing desc, s.endurance desc, p.lastName")
    List<Player> bestPlayers(LocalDate after, LocalDate before);

}
