package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.Protocol;
import org.example.app.dal.repositories.interfaces.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ProtocolRepositoryImpl extends BaseRepository<Protocol, UUID> implements ProtocolRepository {
    public ProtocolRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
