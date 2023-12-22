package org.example.app.bll.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.app.bll.dto.CitizenDTO;
import org.example.app.bll.dto.mapping.CitizenMapper;
import org.example.app.bll.service.interfaces.CitizenService;
import org.example.app.dal.UOW.UnitOfWork;
import org.example.app.dal.entities.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final UnitOfWork unitOfWork;
    @Override
    public List<CitizenDTO> getAll() {
        List<Citizen> citizens = unitOfWork.getCitizenRepository().findAll();

        return citizens.stream().map(CitizenMapper::toDto).toList();
    }
}
