package org.example.app.bll.dto;

import java.util.UUID;

public class CitizenDTO extends UserDTO {
    public CitizenDTO(UUID id, String name, String login) {
        super(id, login, name);
    }
}
