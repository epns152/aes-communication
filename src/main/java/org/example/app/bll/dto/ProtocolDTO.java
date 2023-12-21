package org.example.app.bll.dto;

import org.example.app.dal.entities.enums.ProtocolStatus;

import java.util.UUID;

public record ProtocolDTO(
        UUID id,
        String protocolText,
        ProtocolStatus status
) {
}
