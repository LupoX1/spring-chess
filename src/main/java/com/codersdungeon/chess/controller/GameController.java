package com.codersdungeon.chess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @GetMapping("/test")
    public String test(){
        return "It Works!";
    }

}
