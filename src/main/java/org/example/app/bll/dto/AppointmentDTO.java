package org.example.app.bll.dto;

import org.example.app.dal.entities.enums.AppointmentStatus;

import java.util.List;
import java.util.UUID;

public record AppointmentDTO(
        UUID id,
        String appointmentDate,
        int appointmentDuration,
        AppointmentStatus status,
        List<UserDTO> participants,
        ProtocolDTO protocol,
        String cancellationMessage
) {
}
