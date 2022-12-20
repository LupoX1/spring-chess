package com.codersdungeon.chess.users;

import java.util.List;

public class PlayerListDTO {
    public List<String> players;

    @Override
    public String toString() {
        return "PlayerListDTO{" +
                "players=" + players +
                '}';
    }
}
