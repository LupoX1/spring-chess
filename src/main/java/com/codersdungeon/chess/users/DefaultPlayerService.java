package com.codersdungeon.chess.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultPlayerService implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Player registerNewUserAccount(PlayerDTO playerDTO){

        Player player = new Player();
        player.setUsername(playerDTO.username);
        player.setPassword(passwordEncoder.encode(playerDTO.password));
        player.setEnabled(true);
        player.addRole(new UserRole("PLAYER"));
        return playerRepository.save(player);
    }
}
