package com.codersdungeon.chess.service;

import com.codersdungeon.chess.repository.PlayerRepository;
import com.codersdungeon.chess.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPlayerService implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public Player registerNewUserAccount(PlayerDTO playerDTO){

        Player player = new Player();
        player.setEmail(playerDTO.username);
        player.setPassword(passwordEncoder.encode(playerDTO.password));
        player.setEnabled(true);
        player.addRole(new UserRole("PLAYER"));
        return playerRepository.save(player);
    }

    @Override
    public PlayerListDTO lista() {
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
}
