package org.example.app.bll.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDTO {

    private final UUID id;
    private final String login;
    private final String name;
    private final String password;

    public UserDTO(UUID id, String login, String name, String password) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
    }

}
