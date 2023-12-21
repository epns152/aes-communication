package org.example.app.bll.dto;

import java.util.UUID;

public class UserDTO {

    private final UUID id;
    private final String login;
    private final String name;

    public UserDTO(UUID id, String login, String name) {
        this.id = id;
        this.login = login;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }
}
