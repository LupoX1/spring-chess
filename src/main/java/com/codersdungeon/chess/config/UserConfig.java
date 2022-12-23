package com.codersdungeon.chess.config;

import com.codersdungeon.chess.repository.PlayerRepository;
import com.codersdungeon.chess.users.Player;
import com.codersdungeon.chess.users.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Configuration
@Profile("dev")
public class UserConfig {
    private static final Logger LOG = LoggerFactory.getLogger(WebSecurity.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlayerRepository playerRepository;

    @Transactional
   @PostConstruct
    @Profile("dev")
    public void createTestUsers() {
        LOG.debug("dev config");
        if(playerRepository.findById("giovanni@gmail.com").isPresent()){
            return;
        }

        Player player = new Player();
        player.setEmail("giovanni@gmail.com");
        player.setPassword(passwordEncoder.encode("password"));
        player.addRole(new UserRole("PLAYER"));
        player.setEnabled(true);

        playerRepository.save(player);
    }


}
