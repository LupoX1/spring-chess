package com.codersdungeon.chess.repository;

import com.codersdungeon.chess.users.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    @Query(value = "SELECT COUNT(*) FROM player", nativeQuery = true)
    int numPlayers();

}