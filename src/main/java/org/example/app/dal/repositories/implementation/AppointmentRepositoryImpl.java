package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.Appointment;
import org.example.app.dal.repositories.interfaces.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AppointmentRepositoryImpl extends BaseRepository<Appointment, UUID> implements AppointmentRepository {
    @Autowired
    public AppointmentRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
