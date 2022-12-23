package com.codersdungeon.chess.websocket;

public class LoginMessage {

    private String content;

    public LoginMessage() {
    }

    public LoginMessage(String name) {
        this.content = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String name) {
        this.content = name;
    }
}