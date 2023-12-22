package org.example.app.bll.service.impl;

import org.example.app.bll.dto.CitizenDTO;
import org.example.app.bll.service.interfaces.CitizenService;
import org.example.app.dal.UOW.impl.UnitOfWorkImpl;
import org.example.app.dal.entities.Citizen;
import org.example.app.dal.repositories.interfaces.CitizenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class CitizenServiceImplTest {
    @MockBean
    private UnitOfWorkImpl unitOfWork;
    @MockBean
    private CitizenRepository citizenRepository;

    private CitizenService citizenService;

    @BeforeEach
    void setUp() {
        citizenService = new CitizenServiceImpl(unitOfWork);
    }

    @Test
    void getAll_getAllCitizens_returnCitizenDTOList() {
        // Arrange
        var citizen1 = new Citizen();
        citizen1.setId(UUID.randomUUID());
        citizen1.setLogin("login1");
        citizen1.setName("name1");
        var citizen2 = new Citizen();
        citizen2.setId(UUID.randomUUID());
        citizen2.setLogin("login2");
        citizen2.setName("name2");

        Mockito.when(unitOfWork.getCitizenRepository()).thenReturn(citizenRepository);
        Mockito.when(unitOfWork.getCitizenRepository().findAll()).thenReturn(List.of(citizen1, citizen2));

        // Act
        var citizens = citizenService.getAll();

        // Assert
        Assertions.assertNotNull(citizens);
        Assertions.assertEquals(2, citizens.size());
        Assertions.assertEquals(citizen1.getId(), citizens.get(0).getId());
        Assertions.assertEquals(citizen2.getId(), citizens.get(1).getId());
        Assertions.assertEquals(CitizenDTO.class, citizens.get(0).getClass());
    }
}
