package com.codersdungeon.chess.controller;

import com.codersdungeon.chess.service.DefaultPlayerService;
import com.codersdungeon.chess.users.PlayerDTO;
import com.codersdungeon.chess.users.PlayerDetails;
import com.codersdungeon.chess.users.PlayerListDTO;
import com.codersdungeon.chess.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/active")
    PlayerListDTO activePlayers(){
      return playerService.lista();
    }

    @PostMapping("/register")
    void register(@RequestBody @Valid PlayerDTO playerDTO){
        playerService.registerNewUserAccount(playerDTO);
    }
}
