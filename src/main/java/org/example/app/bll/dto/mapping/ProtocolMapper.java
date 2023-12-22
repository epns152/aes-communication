package org.example.app.bll.dto.mapping;

import org.example.app.bll.dto.ProtocolDTO;
import org.example.app.dal.entities.Protocol;

public class ProtocolMapper {
    public static ProtocolDTO toDto(Protocol protocol) {
        return new ProtocolDTO(protocol.getId(),
                protocol.getProtocolText(),
                protocol.getStatus());
    }

    public static Protocol toEntity(ProtocolDTO protocolDTO) {
        Protocol protocol = new org.example.app.dal.entities.Protocol();
        protocol.setId(protocolDTO.id());
        protocol.setProtocolText(protocolDTO.protocolText());
        protocol.setStatus(protocolDTO.status());
        return protocol;
    }
}

