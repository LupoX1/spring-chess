package com.codersdungeon.chess.users;

import com.codersdungeon.chess.websocket.LoginMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessageLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SendMessageAuthenticationSuccessHandler.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        LOG.info("Log out: {}", authentication);

        String nickname = ((PlayerDetails)authentication.getPrincipal()).getPlayer().getNickname();

        simpMessagingTemplate.convertAndSend("/topic/greetings", new LoginMessage(nickname + " logged out"));

        response.sendRedirect("/lobby.html");
    
    }
}
