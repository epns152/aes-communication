package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.AESWorker;
import org.example.app.dal.repositories.interfaces.AESWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AESWorkerRepositoryImpl extends BaseRepository<AESWorker, UUID> implements AESWorkerRepository {
    public AESWorkerRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
