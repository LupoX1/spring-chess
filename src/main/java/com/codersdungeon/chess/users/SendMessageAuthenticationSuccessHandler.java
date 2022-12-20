package com.codersdungeon.chess.users;

import com.codersdungeon.chess.websocket.LoginMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessageAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SendMessageAuthenticationSuccessHandler.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException {

        LOG.info("Log in: {}", authentication);

        simpMessagingTemplate.convertAndSend("/topic/greetings", new LoginMessage(authentication.getName()));

        response.sendRedirect("/index.html");
    }
}