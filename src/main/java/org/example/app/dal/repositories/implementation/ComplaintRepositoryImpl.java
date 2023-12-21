package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.Complaint;
import org.example.app.dal.repositories.interfaces.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ComplaintRepositoryImpl extends BaseRepository<Complaint, UUID> implements ComplaintRepository {
    public ComplaintRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
