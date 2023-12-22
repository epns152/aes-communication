package org.example.app.bll.dto.mapping;

import org.example.app.bll.dto.AESWorkerDTO;
import org.example.app.bll.dto.CitizenDTO;
import org.example.app.bll.dto.AppointmentDTO;
import org.example.app.bll.dto.UserDTO;
import org.example.app.dal.entities.AESWorker;
import org.example.app.dal.entities.Appointment;
import org.example.app.dal.entities.Citizen;
import org.example.app.dal.entities.abstractions.User;

import java.util.List;

public class AppointmentMapper {
    public static AppointmentDTO participantsToDto(Appointment appointment) {
        return new AppointmentDTO(appointment.getId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentDuration(),
                appointment.getStatus(),
                participantsToDto(appointment.getParticipants()),
                ProtocolMapper.toDto(appointment.getProtocol()),
                appointment.getCancellationMessage());
    }

    public static Appointment participantsToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.id());
        appointment.setAppointmentDate(appointmentDTO.appointmentDate());
        appointment.setAppointmentDuration(appointmentDTO.appointmentDuration());
        appointment.setStatus(appointmentDTO.status());
        appointment.setParticipants(participantsToEntity(appointmentDTO.participants()));
        appointment.setProtocol(ProtocolMapper.toEntity(appointmentDTO.protocol()));
        appointment.setCancellationMessage(appointmentDTO.cancellationMessage());
        return appointment;
    }
    
    private static List<UserDTO> participantsToDto(List<User> participants) {
        return participants.stream().map(x -> {
            if (x instanceof Citizen) {
                return CitizenMapper.toDto((Citizen) x);
            } else if (x instanceof AESWorker) {
                return AESWorkerMapper.toDto((AESWorker) x);
            } else {
                throw new RuntimeException("Unknown user type");
            }
        }).toList();
    }
    
    private static List<User> participantsToEntity(List<UserDTO> participants) {
        return participants.stream().map(x -> {
            if (x instanceof CitizenDTO) {
                return CitizenMapper.toEntity((CitizenDTO) x);
            } else if (x instanceof AESWorkerDTO) {
                return AESWorkerMapper.toEntity((AESWorkerDTO) x);
            } else {
                throw new RuntimeException("Unknown user type");
            }
        }).toList();
    }
}
