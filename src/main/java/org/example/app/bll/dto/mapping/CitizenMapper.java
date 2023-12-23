package org.example.app.bll.dto.mapping;

import org.example.app.bll.dto.CitizenDTO;
import org.example.app.dal.entities.Citizen;

public class CitizenMapper {
    public static CitizenDTO toDto(Citizen citizen) {
        return new CitizenDTO(citizen.getId(),
                citizen.getName(),
                citizen.getLogin(),
                citizen.getPassword());
    }

    public static Citizen toEntity(CitizenDTO citizenDTO) {
        Citizen citizen = new Citizen();
        citizen.setId(citizenDTO.getId());
        citizen.setName(citizenDTO.getName());
        citizen.setLogin(citizenDTO.getLogin());
        citizen.setPassword(citizenDTO.getPassword());
        return citizen;
    }
}
