package com.codersdungeon.chess.websocket;

public class LoginMessage {

    private String name;

    public LoginMessage() {
    }

    public LoginMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}