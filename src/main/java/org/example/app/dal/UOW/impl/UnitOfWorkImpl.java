package org.example.app.dal.UOW.impl;

import lombok.RequiredArgsConstructor;
import org.example.app.dal.UOW.UnitOfWork;
import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.repositories.implementation.*;
import org.example.app.dal.repositories.interfaces.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnitOfWorkImpl implements UnitOfWork {

    private AESWorkerRepository aesWorkerRepository;
    private AppointmentRepository appointmentRepository;
    private CitizenRepository citizenRepository;
    private ComplaintRepository complaintRepository;
    private OfferRepository offerRepository;
    private ProtocolRepository protocolRepository;

    private final EntityManagerUtil entityManagerUtil;

    @Override
    public AESWorkerRepository getAESWorkerRepository() {
        if (aesWorkerRepository == null)
            aesWorkerRepository = new AESWorkerRepositoryImpl(entityManagerUtil);
        return aesWorkerRepository;
    }

    @Override
    public AppointmentRepository getAppointmentRepository() {
        if (appointmentRepository == null)
            appointmentRepository = new AppointmentRepositoryImpl(entityManagerUtil);
        return appointmentRepository;
    }

    @Override
    public CitizenRepository getCitizenRepository() {
        if (citizenRepository == null)
            citizenRepository = new CitizenRepositoryImpl(entityManagerUtil);
        return citizenRepository;
    }

    @Override
    public ComplaintRepository getComplaintRepository() {
        if (complaintRepository == null)
            complaintRepository = new ComplaintRepositoryImpl(entityManagerUtil);
        return complaintRepository;
    }

    @Override
    public OfferRepository getOfferRepository() {
        if (offerRepository == null)
            offerRepository = new OfferRepositoryImpl(entityManagerUtil);
        return offerRepository;
    }

    @Override
    public ProtocolRepository getProtocolRepository() {
        if (protocolRepository == null)
            protocolRepository = new ProtocolRepositoryImpl(entityManagerUtil);
        return protocolRepository;
    }

    @Override
    public void saveChanges() {
        entityManagerUtil.performWithinTx(entityManager -> {
            entityManager.flush();
            entityManager.clear();
        });
    }

    @Override
    public void close() {
        entityManagerUtil.performWithinTx(entityManager -> {
            entityManager.close();
            entityManager.getEntityManagerFactory().close();
        });
    }
}