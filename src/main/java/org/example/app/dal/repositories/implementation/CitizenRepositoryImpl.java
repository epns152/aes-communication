package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.Citizen;
import org.example.app.dal.repositories.interfaces.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CitizenRepositoryImpl extends BaseRepository<Citizen, UUID> implements CitizenRepository {
    public CitizenRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
