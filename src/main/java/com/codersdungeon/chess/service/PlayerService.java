package com.codersdungeon.chess.service;

import com.codersdungeon.chess.users.Player;
import com.codersdungeon.chess.users.PlayerDTO;
import com.codersdungeon.chess.users.PlayerListDTO;

public interface PlayerService {
    Player registerNewUserAccount(PlayerDTO playerDTO);
    PlayerListDTO lista();

}
