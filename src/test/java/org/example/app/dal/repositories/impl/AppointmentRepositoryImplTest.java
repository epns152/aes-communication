package org.example.app.dal.repositories.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.app.App;
import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.AESWorker;
import org.example.app.dal.entities.Appointment;
import org.example.app.dal.entities.Protocol;
import org.example.app.dal.entities.enums.AppointmentStatus;
import org.example.app.dal.repositories.implementation.AppointmentRepositoryImpl;
import org.example.app.dal.repositories.interfaces.AppointmentRepository;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AppointmentRepositoryImpl.class, EntityManagerUtil.class})
public class AppointmentRepositoryImplTest {

    @MockBean
    SessionFactory entityManagerFactory;

    @MockBean
    EntityManager entityManager;

    @MockBean
    EntityTransaction entityTransaction;

    @Autowired
    AppointmentRepository appointmentRepository;


    @BeforeEach
    void setUp() {
        Mockito.when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
        Mockito.doNothing().when(entityTransaction).begin();
        Mockito.doNothing().when(entityTransaction).commit();
        Mockito.doNothing().when(entityTransaction).rollback();
        Mockito.doNothing().when(entityManager).close();
    }

    @Test
    void save_newAppointmentToRepository_persistIsCalled() {
        // Arrange
        Appointment appointment = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        Mockito.doNothing().when(entityManager).persist(appointment);

        // Act
        appointmentRepository.save(appointment);

        // Assert
        Mockito.verify(entityManager, Mockito.times(1)).persist(appointment);
    }

    @Test
    void save_nullToRepository_NPEIsThrown() {
        // Arrange
        Appointment appointment = null;

        // Act
        var error = Assertions.assertThrows(NullPointerException.class, () -> appointmentRepository.save(appointment));

        // Assert
        Assertions.assertNull(error.getMessage());
    }

    @Test
    void findById_findForExistingAppointment_findIsCalled() {
        // Arrange
        Appointment appointment = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        Mockito.when(entityManager.find(Appointment.class, appointment.getId())).thenReturn(appointment);

        // Act
        var result = appointmentRepository.findById(appointment.getId());

        // Assert
        Mockito.verify(entityManager, Mockito.times(1)).find(Appointment.class, appointment.getId());
        Assertions.assertEquals(appointment, result.orElse(null));
    }

    @Test
    void findByPredicate_searchByPredicateDate_createQueryIsCalled_returnedAppointments() {
        // Arrange
        Appointment appointment1 = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();
        Appointment appointment2 = Appointment.builder()
                .appointmentDate("2023-01-02")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        var query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery("from " + Appointment.class.getName(), Appointment.class)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(List.of(appointment1, appointment2));

        // Act
        var result = appointmentRepository.findByPredicate(a -> a.getAppointmentDate().equals("2023-01-02"));

        // Assert
        Mockito.verify(entityManager, Mockito.times(1))
                .createQuery("from " + Appointment.class.getName(), Appointment.class);
        Assertions.assertEquals(appointment2, result.orElse(null));
    }

    @Test
    void findAll_getAllAppointments_returnListOfAppointments() {
        // Arrange
        Appointment appointment = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        var query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery("from " + Appointment.class.getName())).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(List.of(appointment));

        // Act
        var result = appointmentRepository.findAll();

        // Assert
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(List.of(appointment), result);
        Assertions.assertEquals(appointment, result.get(0));
    }

    @Test
    void update_updateExistingAppointment_callEntityManagerMerge() {
        // Arrange
        Appointment appointment = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        Mockito.when(entityManager.merge(appointment)).thenReturn(appointment);

        // Act
        appointmentRepository.update(appointment);

        // Assert
        Mockito.verify(entityManager, Mockito.times(1)).merge(appointment);
    }

    @Test
    void delete_removeExistingAppointment_callEntityManagerRemove() {
        // Arrange
        Appointment appointment = Appointment.builder()
                .appointmentDate("2023-01-01")
                .status(AppointmentStatus.PENDING)
                .protocol(new Protocol())
                .participants(List.of(new AESWorker()))
                .build();

        Mockito.doNothing().when(entityManager).remove(appointment);

        // Act
        appointmentRepository.delete(appointment);

        // Assert
        Mockito.verify(entityManager, Mockito.times(1)).remove(appointment);
    }
}
