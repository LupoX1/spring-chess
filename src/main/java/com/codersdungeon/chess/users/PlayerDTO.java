package com.codersdungeon.chess.users;

import javax.validation.constraints.NotBlank;

public class PlayerDTO {
    @NotBlank
    public String username;
    @NotBlank
    public String password;
}
