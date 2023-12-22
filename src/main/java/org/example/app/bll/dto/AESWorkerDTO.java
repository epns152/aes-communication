package org.example.app.bll.dto;

import java.util.UUID;

public class AESWorkerDTO extends UserDTO {
    public AESWorkerDTO(UUID id, String name, String login) {
        super(id, login, name);
    }
}
