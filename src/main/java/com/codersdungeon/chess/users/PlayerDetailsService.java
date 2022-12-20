package com.codersdungeon.chess.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return playerRepository.findById(username).map(PlayerDetails::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
