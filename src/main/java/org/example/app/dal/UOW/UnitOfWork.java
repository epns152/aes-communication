package org.example.app.dal.UOW;

import org.example.app.dal.repositories.interfaces.*;

public interface UnitOfWork {

    AESWorkerRepository getAESWorkerRepository();

    AppointmentRepository getAppointmentRepository();

    CitizenRepository getCitizenRepository();

    ComplaintRepository getComplaintRepository();

    OfferRepository getOfferRepository();

    ProtocolRepository getProtocolRepository();

    void saveChanges();

    void close();
}
