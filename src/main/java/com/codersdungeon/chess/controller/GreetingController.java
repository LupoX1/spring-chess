package com.codersdungeon.chess.controller;

import com.codersdungeon.chess.websocket.Greeting;
import com.codersdungeon.chess.websocket.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(@Payload HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getMessage()) + "!");
    }

    @PostMapping("/hello-user")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void greetingUser(@RequestBody HelloMessage message, Principal principal) throws Exception {
        Thread.sleep(1000); // simulated delay
        String toUser = message.getToUser();
        String fromUser = principal.getName();
        simpMessagingTemplate.convertAndSendToUser(
                toUser,
                "/queue/user-messages",
                new Greeting(HtmlUtils.htmlEscape(message.getMessage() + ", from (" + fromUser + ") !"))
        );
    }

}