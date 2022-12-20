package com.codersdungeon.chess.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public LoginMessage greeting() throws Exception {
        Thread.sleep(1000); // simulated delay
        return new LoginMessage();
    }

}
