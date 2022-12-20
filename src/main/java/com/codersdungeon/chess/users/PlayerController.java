package com.codersdungeon.chess.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/active")
    PlayerListDTO activePlayers(){
        PlayerListDTO response = new PlayerListDTO();
        response.players = new ArrayList<>();

        for (final Object principal : sessionRegistry.getAllPrincipals()) {
            if (principal instanceof PlayerDetails) {
                final PlayerDetails user = (PlayerDetails) principal;

                List<SessionInformation> activeUserSessions = sessionRegistry.getAllSessions(principal, false);
                if (!activeUserSessions.isEmpty()) {
                    response.players.add(user.getUsername());
                }
            }
        }

        return response;
    }

    @PostMapping("/register")
    void register(@RequestBody @Valid PlayerDTO playerDTO){
        playerService.registerNewUserAccount(playerDTO);
    }
}
